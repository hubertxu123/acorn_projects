package com.chinadrtv.erp.sales.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    private static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    private static HttpSession getSession() {
        HttpSession instance = SessionUtils.getRequest().getSession();
        return instance;
    }

    public static Object get(String key) {
        return getSession().getAttribute(key);

    }

    public static void set(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    public static void remove(String name) {
        getSession().removeAttribute(name);
    }
}
