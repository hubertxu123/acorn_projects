package com.chinadrtv.taobao.service.impl;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinadrtv.dal.oms.dao.PreTradeItemDao;
import com.chinadrtv.model.oms.PreTradeDetail;
import com.chinadrtv.model.oms.PreTradeItem;
import com.chinadrtv.model.oms.dto.PreTradeDto;
import com.chinadrtv.taobao.model.TaobaoOrderConfig;
import com.chinadrtv.taobao.service.ImportTransformService;

/**
 * Created with (TC).
 * User: 徐志凯
 * Date: 13-10-29
 * 橡果国际-系统集成部
 * Copyright (c) 2012-2013 ACORN, Inc. All rights reserved.
 */
@Service
public class ImportTransformServiceImpl implements ImportTransformService {
	
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ImportTransformServiceImpl.class);

    private final String NO_INVOICE_ORDER_TYPE_127 = "127" ;
    private final String NO_INVOICE_START_DATE = "2013-04-01" ;
    private final String NO_INVOICE_ORDER_TYPE_98 = "98" ;

    private Smooks smooks=null;
    
    @Autowired
    private PreTradeItemDao preTradeItemDao;
    
	public ImportTransformServiceImpl() {
		System.out.println("ImportTransformServiceImpl is created");
	}

	@PostConstruct
	public void init() throws Exception {
		try {
			smooks = new Smooks("smooks/smooks-config.xml");
		} catch (Exception exp) {
			logger.error("smooks init error:", exp);
			throw exp;
		}
	}

    @Override
    public List<PreTradeDto> transform(TaobaoOrderConfig taobaoOrderConfig, List<String> tradeList) {
        List<PreTradeDto> preTradeList=new ArrayList<PreTradeDto>();

		if (smooks == null) {
			logger.error("smooks is null");
			return null;
		}
		
		try {
			for (String str : tradeList) {
				List<PreTradeDto> list = transformXMLToPOJO(smooks, str);
				if (list != null && list.size() > 0) {
					
					for (PreTradeDto trade : list) {
						
						//只有乐纷纷店拆单
						if("259".equals(taobaoOrderConfig.getTradeType())) {
							//拆单匹配
							Set<Integer> splitSet = new HashSet<Integer>();
							
							// 处理前置订单明细skuId为空问题
							List<PreTradeDetail> detailList = trade.getPreTradeDetails();
							for (PreTradeDetail detail : detailList) {
								if (null == detail.getSkuId()) {
									detail.setSkuId(detail.getItemId());
								}
								if (null == detail.getOutSkuId() || "".equals(detail.getOutSkuId().trim())) {
									detail.setOutSkuId(detail.getOutItemId());
								}
								//匹配是否拆单
								String outSkuId = detail.getOutSkuId();
								if(null != outSkuId && !"".equals(outSkuId.trim())) {
									PreTradeItem preTradeItem = preTradeItemDao.queryByItemId(outSkuId);
									if(null != preTradeItem && preTradeItem.isActive()) {
										splitSet.add(preTradeItem.getWarehouseType());
										detail.setWarehouseType(preTradeItem.getWarehouseType());
										detail.setItemTradeType(preTradeItem.getItemTradeType());
										detail.setItemTmsCode(preTradeItem.getItemTmsCode());
									}	
								}
							}

							//拆分子订单数量
							Integer splitNum = splitSet.size();
							trade.setSplitFlag(splitNum);
						}else{
							// 处理前置订单明细skuId为空问题
							List<PreTradeDetail> detailList = trade.getPreTradeDetails();
							for (PreTradeDetail detail : detailList) {
								if (null == detail.getSkuId()) {
									detail.setSkuId(detail.getItemId());
								}
								if (null == detail.getOutSkuId() || "".equals(detail.getOutSkuId().trim())) {
									detail.setOutSkuId(detail.getOutItemId());
								}
							}
						}

						if (trade.getInvoiceTitle() == null || "".equals(trade.getInvoiceTitle())) {
						} else {
							trade.setInvoiceComment("1");
						}
						// 附加属性设置
						trade.setSourceId(taobaoOrderConfig.getSourceId().longValue());
						// trade.setCustomerId(taobaoConfig.getCustomerId());
						trade.setTradeType(taobaoOrderConfig.getTradeType());
						// 针对127订单类型，做无发票处理，其实日期2013-04-01
						if (NO_INVOICE_ORDER_TYPE_127.equals(trade.getTradeType())
								&& trade.getOutCrdt().after(getDateStart(NO_INVOICE_START_DATE))) {
							trade.setInvoiceComment("0");
							trade.setInvoiceTitle("不需要开具发票");
						}
						if (NO_INVOICE_ORDER_TYPE_98.equals(trade.getTradeType())) {
							trade.setInvoiceComment("0");
							trade.setInvoiceTitle("不需要开具发票");
						}
						// trade.setTmsCode(taobaoConfig.getTmsCode());
						trade.setCrdt(new Date());
						
						preTradeList.add(trade);
					}
				}
			}
		} catch (Exception exp) {
			logger.error("transform error:", exp);
			throw new RuntimeException("transform error:", exp);
		} 

        return preTradeList;
    }

    /**
     * 取特定日期的零点零分零秒
     */
    private Date getDateStart(String strDate) {
        SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null ;
        try {
            date = shortDateFormat.parse(strDate) ;
        } catch (ParseException e) {
        }
        return date ;
    }

    public List<PreTradeDto> transformXMLToPOJO(Smooks smooks, String str) {
        List<PreTradeDto> tradelist = null;
        Source source = new StreamSource(new StringReader(str));

        JavaResult javaResult = new JavaResult();

        smooks.filterSource(source, javaResult);

        tradelist = (List<PreTradeDto>) javaResult.getBean("tradeList");
        return tradelist;
    }
}
