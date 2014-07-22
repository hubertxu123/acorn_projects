package com.chinadrtv.gonghang.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import com.chinadrtv.gonghang.dal.dto.OrderDetailDto;
import com.chinadrtv.gonghang.dal.dto.OrderHeaderDto;
import com.chinadrtv.gonghang.dal.dto.ResponseHeaderDto;
import com.chinadrtv.gonghang.dal.model.OrderConfig;
import com.chinadrtv.gonghang.service.OrderFeedbackService;
import com.chinadrtv.gonghang.service.OrderImportService;
import com.chinadrtv.gonghang.util.EncryptUtil;
import com.chinadrtv.model.oms.PreTradeDetail;
import com.chinadrtv.model.oms.dto.PreTradeDto;
import com.chinadrtv.model.oms.dto.PreTradeLotDto;
import com.chinadrtv.service.oms.PreTradeImportService;

/**
 * Created with IntelliJ IDEA.
 * User: liukuan
 * Date: 14-4-22
 * Time: 下午3:39
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderImportServiceImpl implements OrderImportService {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(OrderImportServiceImpl.class);
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PreTradeImportService preTradeImportService;
    @Autowired
    private OrderFeedbackService orderFeedbackService;
    
    private Smooks smooks = null;
    
    /**
	 * <p>Title: </p>
	 * <p>Description: </p>
     * @throws SAXException 
     * @throws IOException 
	 */ 
	public OrderImportServiceImpl() throws IOException, SAXException {
		super();
		smooks = new Smooks("smooks/smooks-config.xml");
	}


	/** 
	 * <p>Title: input</p>
	 * <p>Description: </p>
	 * @param gongHangOrderConfigList
	 * @param startDate
	 * @param endDate
	 * @throws Exception 
	 * @see com.chinadrtv.gonghang.service.IcbcOrderInputService#input(java.util.List, java.util.Date, java.util.Date)
	 */ 
	@Override
	public void input(List<OrderConfig> configList, Date startDate, Date endDate) throws Exception {
		
		for(OrderConfig config : configList) {
			List<OrderHeaderDto> orderHeaderList = this.postOrderHeader(config, startDate, endDate);
			
			PreTradeLotDto preTradeLotDto = this.postOrderDetailList(config, orderHeaderList);
			
			if(null != preTradeLotDto) {
				preTradeImportService.importPretrades(preTradeLotDto);	
			}
		}
	}
    
	/**
	 * <p>
	 * </p>
	 * @param orderIdList
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	private PreTradeLotDto postOrderDetailList(OrderConfig config, List<OrderHeaderDto> orderHeaderList) throws Exception {
		PreTradeLotDto preTradeLotDto = new PreTradeLotDto();
		List<PreTradeDto> preTradeDtoList = new ArrayList<PreTradeDto>();
		
		for(OrderHeaderDto dto : orderHeaderList) {
			PreTradeDto preTradeDto = this.postOrderDetail(config, dto);
			if (null != preTradeDto) {
				preTradeDtoList.add(preTradeDto);
			}
		}
		
		if(preTradeDtoList.size() > 0) {
			preTradeLotDto.setPreTrades(preTradeDtoList);
			return preTradeLotDto;
		}
		
		return null;
	}

	/**
	 * <p></p>
	 * @param config
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	private List<OrderHeaderDto> postOrderHeader(OrderConfig config, Date startDate, Date endDate) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String method = "icbcb2c.order.list";
		String reqData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						 "<body>" +
						 "<create_start_time>" + sdf.format(startDate) + "</create_start_time>" +
						 "<create_end_time>" + sdf.format(endDate) + "</create_end_time>" +
						 "<modify_time_from></modify_time_from>" +
						 "<modify_time_to></modify_time_to>" +
						 "<order_status>01</order_status>" +
						 "</body>";
		
		String requestUrl = EncryptUtil.generateRequestUrl(config, method, reqData);

		logger.debug(requestUrl);
		
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.postForEntity(requestUrl, new Object(), String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null ==response || response.getStatusCode().value() != 200) {
    		throw new Exception("request ICBC web service error!");
    	}
		
		String content = new String(response.getBody().getBytes("ISO-8859-1"), "UTF-8");
		
		content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response><head><method>icbcb2c.order.list</method><req_sid>20130508000000001</req_sid><version>1.0</version><timestamp>123111111111</timestamp><app_key>10100011</app_key><auth_code>AfcdE</auth_code><ret_code>00000000</ret_code><ret_msg>OK</ret_msg><sign>581149147A@#%^ASDFQEQW</sign></head><body><order_list><order><order_id>12312312312</order_id><order_create_time>2013-12-12 10:00:00</order_create_time><order_modify_time>2013-12-12 10:00:00</order_modify_time><order_status>01</order_status></order></order_list></body></response>";
		
		logger.debug("post content: " + content);
			
		List<OrderHeaderDto> orderHeaderList = this.orderHeaderAdapter(content);
		
		return orderHeaderList;
	}

	/**
	 * <p></p>
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	private List<OrderHeaderDto> orderHeaderAdapter(String content) throws Exception {
		List<OrderHeaderDto> orderHeaderList = new ArrayList<OrderHeaderDto>();
		
		ExecutionContext executionContext = smooks.createExecutionContext();
		JavaResult result = new JavaResult();

		ByteArrayInputStream baInputStream = new ByteArrayInputStream(content.getBytes());
		smooks.filterSource(executionContext, new StreamSource(baInputStream), result);

		ResponseHeaderDto responseHeader = (ResponseHeaderDto) result.getBean("responseHeader");
		if(null == responseHeader || null == responseHeader.getRetMsg() || !"ok".equalsIgnoreCase(responseHeader.getRetMsg())) {
			throw new Exception("post ICBC service failed.");
		}
		orderHeaderList = (List<OrderHeaderDto>) result.getBean("orderIdList");	            
		
		return orderHeaderList;
	}

	/**
	 * <p></p>
	 * @param content
	 * @return
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	private PreTradeDto postOrderDetail(OrderConfig config, OrderHeaderDto dto) throws Exception {
		
		String method = "icbcb2c.order.detail";
		String reqData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						 "<body>" +
						 "<order_ids>" + dto.getOrderId() + "</order_ids>" +
						 "</body>";
		
		String requestUrl = EncryptUtil.generateRequestUrl(config, method, reqData);

		logger.debug(requestUrl);
		
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.postForEntity(requestUrl, new Object(), String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null ==response || response.getStatusCode().value() != 200) {
    		throw new Exception("request ICBC web service error!");
    	}
		
		String content = new String(response.getBody().getBytes("ISO-8859-1"), "UTF-8");
		
		PreTradeDto preTradeDto = this.preTradeDtoAdapter(content);
		
		return preTradeDto;
	}

	/**
	 * <p></p>
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	private PreTradeDto preTradeDtoAdapter(String content) throws Exception {
		ExecutionContext executionContext = smooks.createExecutionContext();
		JavaResult result = new JavaResult();

		ByteArrayInputStream baInputStream = new ByteArrayInputStream(content.getBytes());
		smooks.filterSource(executionContext, new StreamSource(baInputStream), result);

		ResponseHeaderDto responseHeader = (ResponseHeaderDto) result.getBean("responseHeader");
		if(null == responseHeader || null == responseHeader.getRetMsg() || !"ok".equalsIgnoreCase(responseHeader.getRetMsg())) {
			throw new Exception("post ICBC service failed.");
		}
		
		OrderHeaderDto orderHeaderDto = (OrderHeaderDto) result.getBean("orderHeaderDto");
		
		if(null == orderHeaderDto) {
			return null;
		}
		PreTradeDto preTradeDto = this.preTradeDtoAdapter(orderHeaderDto);
		
		return preTradeDto;
	}

	/**
	 * <p></p>
	 * @param orderHeaderDto
	 * @return
	 */
	private PreTradeDto preTradeDtoAdapter(OrderHeaderDto orderHeaderDto) {
		PreTradeDto preTradeDto = new PreTradeDto();
		
		//preTradeDto.setAdvFee(advFee);
		//preTradeDto.setAlipayTradeId();
		//preTradeDto.setBuyerAlipayId();
		preTradeDto.setBuyerId(orderHeaderDto.getOrderBuyerId());
		preTradeDto.setBuyerMessage(orderHeaderDto.getOrderBuyerRemark());
		preTradeDto.setBuyerNick(orderHeaderDto.getOrderBuyerName());
		//preTradeDto.setComisssionFee(comisssionFee);
		preTradeDto.setCrdt(new Date());
		preTradeDto.setCreateDate(new Date());
		//preTradeDto.setCreditFee(creditFee);
		//preTradeDto.setCustomerId(customerId);
		//preTradeDto.setDiscountFee(discountFee);
		//preTradeDto.setErrMsg(errMsg);
		/*
		preTradeDto.setFeedbackDate(feedbackDate);
		preTradeDto.setFeedbackMessageId(feedbackMessageId);
		preTradeDto.setFeedbackRetryCount(feedbackRetryCount);
		preTradeDto.setFeedbackStatus(feedbackStatus);
		preTradeDto.setFeedbackStatusRemark(feedbackStatusRemark);
		preTradeDto.setFeedbackSubmissionId(feedbackSubmissionId);
		preTradeDto.setFeedbackUser(feedbackUser);
		preTradeDto.setImpDate(impDate);
		preTradeDto.setImpStatus(impStatus);
		preTradeDto.setImpStatusRemark(impStatusRemark);
		preTradeDto.setImpUser(impUser);
		*/
		//preTradeDto.setInfo(info);
		preTradeDto.setInvoiceComment(orderHeaderDto.getInvoiceContent());
		preTradeDto.setInvoiceTitle(orderHeaderDto.getInvoiceTitle());
		//preTradeDto.setIsApproval(isApproval);
		//preTradeDto.setIsStat(isStat);
		//preTradeDto.setIsValid(isValid);
		//preTradeDto.setJhsFee(jhsFee);
		preTradeDto.setMailType(orderHeaderDto.getOrderChannel());
		preTradeDto.setOpsTradeId(orderHeaderDto.getOrderId());
		//preTradeDto.setOrdermoney(orderHeaderDto.getOrderAmount().doubleValue());
		preTradeDto.setOutCrdt(orderHeaderDto.getOrderCreateTime());
		preTradeDto.setPayment(orderHeaderDto.getOrderPayAmount().doubleValue());
		preTradeDto.setPaytype(orderHeaderDto.getOrderPaySys());
		//preTradeDto.setPlateformCommissionFee(plateformCommissionFee);
		preTradeDto.setReceiverAddress(orderHeaderDto.getConsigneeAddress());
		preTradeDto.setReceiverarea(orderHeaderDto.getConsigneeDistrict());
		preTradeDto.setReceiverArea(orderHeaderDto.getConsigneeDistrict());
		preTradeDto.setReceiverCity(orderHeaderDto.getConsigneeCity());
		//preTradeDto.setReceiverCounty(receiverCounty);
		preTradeDto.setReceiverMobile(orderHeaderDto.getMobile());
		preTradeDto.setReceiverName(orderHeaderDto.getOrderBuyerName());
		preTradeDto.setReceiverPhone(orderHeaderDto.getPhone());
		preTradeDto.setReceiverPostCode(orderHeaderDto.getZipcode());
		preTradeDto.setReceiverProvince(orderHeaderDto.getConsigneeProvince());
		/*
		preTradeDto.setRefundDate(refundDate);
		preTradeDto.setRefundStatus(refundStatus);
		preTradeDto.setRefundStatusConfirm(refundStatusConfirm);
		preTradeDto.setRefundStatusConfirmDate(refundStatusConfirmDate);
		preTradeDto.setRefundStatusConfirmUser(refundStatusConfirmUser);
		*/
		//preTradeDto.setRemark(remark);
		//preTradeDto.setRetailerCommissionFee(retailerCommissionFee);
		//preTradeDto.setRevenue(revenue);
		preTradeDto.setSellerMessage(orderHeaderDto.getOrderBuyerRemark());
		//preTradeDto.setSendinfo(sendinfo);
		//FIXME
		//preTradeDto.setShippingFee(shippingFee);
		//preTradeDto.setShippingType(shippingType);
		preTradeDto.setSourceId(24L);
		
		List<PreTradeDetail> preTradeDetails = new ArrayList<PreTradeDetail>();
		
		for(OrderDetailDto orderDetailDto : orderHeaderDto.getOrderDetails()) {
			PreTradeDetail pd = new PreTradeDetail();
			
			BigDecimal qty =  new BigDecimal(orderDetailDto.getProductNumber());
			BigDecimal payment = (BigDecimal) (null == orderDetailDto.getProductPrice() ? 0 :orderDetailDto.getProductPrice().multiply(qty));
			
			pd.setIsActive(true);
			pd.setIsValid(true);
			pd.setItemId(orderDetailDto.getProductSkuId());
			pd.setOutItemId(String.valueOf(orderDetailDto.getProductSkuId()));
			
			pd.setPayment(payment.doubleValue());
			pd.setPrice(null == orderDetailDto.getProductPrice() ? 0 : orderDetailDto.getProductPrice().doubleValue());
			pd.setQty(orderDetailDto.getProductNumber());
			pd.setSkuId(orderDetailDto.getProductSkuId());
			pd.setSkuName(orderDetailDto.getProductName());
			//pd.setSourcePreTradeDetailId(sourcePreTradeDetailId);
			
			preTradeDetails.add(pd);
		}
		
		preTradeDto.setPreTradeDetails(preTradeDetails);
		
		return preTradeDto;
	}


}
