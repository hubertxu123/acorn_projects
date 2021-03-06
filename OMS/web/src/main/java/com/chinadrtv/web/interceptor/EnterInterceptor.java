package com.chinadrtv.web.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chinadrtv.common.log.LOG_TYPE;
import com.chinadrtv.util.WebConstants;
import com.chinadrtv.web.util.SerialNumberBuilder;


public class EnterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String journalSeqNo = SerialNumberBuilder.buildJournalSeqNo();
		request.setAttribute(WebConstants.SERIAL_NUMBER, journalSeqNo);
		LOG.info("流水[{}] begin path {}", journalSeqNo, request.getServletPath());
		ServletContext servletContext = request.getSession().getServletContext();
		servletContext.setAttribute("staticFileRoot", request.getContextPath());
		servletContext.setAttribute("staticFileVer", "20130717");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		LOG.info("流水[{}] end path {}", request.getAttribute(WebConstants.SERIAL_NUMBER), request.getServletPath());
	}

	private static final Logger LOG = LoggerFactory.getLogger("LOG_TYPE.PAFF_COMMON.val");
}
