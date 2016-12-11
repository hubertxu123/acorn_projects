package com.chinadrtv.erp.sales.controller;

import com.chinadrtv.erp.sales.dto.User;
import com.chinadrtv.erp.sales.util.SessionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        SessionUtils.remove("user");
        return "login/login";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Map login(User user) {
        Map result = new HashMap();
        if (StringUtils.isNotBlank(user.getPassword()) && StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getAgentNo())) {
            SessionUtils.set("user", user);
            result.put("code", 0);
        } else {
            result.put("code", -1);
            result.put("msg", "登录错误");
        }
        return result;
    }
}
