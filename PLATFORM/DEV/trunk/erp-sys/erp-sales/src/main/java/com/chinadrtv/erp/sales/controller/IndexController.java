package com.chinadrtv.erp.sales.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value = "BASE64_PASSWORD")
public class IndexController extends BaseController {

    @Value("${knowledge.url}")
    private String knowledgeUrl;

    @Value("${distribution.url}")
    private String distributionUrl;

    @RequestMapping("/home/home")
    public ModelAndView home() throws Exception {
        ModelAndView mav = new ModelAndView("home/home");
        mav.addObject("userID", 1);
        mav.addObject("department", 2);
        return mav;
    }

    @RequestMapping("/index")
    public ModelAndView index()
            throws Exception {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

}