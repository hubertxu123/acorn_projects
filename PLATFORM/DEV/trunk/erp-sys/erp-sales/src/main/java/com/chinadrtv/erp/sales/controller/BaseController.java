package com.chinadrtv.erp.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: liuhaidong
 * Date: 12-7-24
 */
@Controller
public abstract class BaseController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseController.class);
    
    private ModelAndView errorModelAndView(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/handling");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }

    //@ExceptionHandler({PageException.class})
    public ModelAndView handleExceptionArray(Exception ex) {
        logger.info("Uncaught exception: " + ex.getClass().getSimpleName());
        logger.info("exception: " + ex.getMessage());
        return errorModelAndView(ex);
    }


}
