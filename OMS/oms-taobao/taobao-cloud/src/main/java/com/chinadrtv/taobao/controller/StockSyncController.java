/*
 * @(#)StockSyncController.java 1.0 2014-7-16下午4:22:46
 *
 * 橡果国际-系统集成部
 * Copyright (c) 2012-2014 ACORN, Inc. All rights reserved.
 */
package com.chinadrtv.taobao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinadrtv.taobao.model.TaobaoOrderConfig;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemQuantityUpdateRequest;
import com.taobao.api.response.ItemQuantityUpdateResponse;

/**
 * <dl>
 *    <dt><b>Title:</b></dt>
 *    <dd>
 *    	none
 *    </dd>
 *    <dt><b>Description:</b></dt>
 *    <dd>
 *    	<p>none
 *    </dd>
 * </dl>
 *
 * @author andrew
 * @version 1.0
 * @since 2014-7-16 下午4:22:46 
 * 
 */
@Controller
public class StockSyncController {
	
	private static transient final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StockSyncController.class);

	@RequestMapping(value = "/syncStockByItem")
	@ResponseBody
	public Map<String, Object> syncStockByItem(TaobaoOrderConfig config, List<Object> itemList) {
		Map<String, Object> rsMap = new HashMap<String, Object>();
		
		TaobaoClient client = null;
		ItemQuantityUpdateResponse response = null;
		
		//FIXME construct 
		for(Object obj : itemList) {
			client = new DefaultTaobaoClient(config.getUrl(), config.getAppkey(), config.getAppSecret());
			ItemQuantityUpdateRequest req = new ItemQuantityUpdateRequest();
			req.setNumIid(23232L);
			req.setQuantity(2L);
			
			try {
				response = client.execute(req , config.getSessionKey());
			} catch (ApiException e) {
				logger.error("call api error", e);
			}
			
			if(null == response || !response.isSuccess()) {
				continue;
			}
			
			//FIXME
		}
		
		return rsMap;
	}
}
