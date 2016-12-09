package com.chinadrtv.erp.sales.controller;

import com.chinadrtv.erp.marketing.core.util.HttpUtil;
import com.chinadrtv.erp.sales.dto.SessionDto;
import com.chinadrtv.erp.sales.dto.User;
import com.chinadrtv.erp.sales.service.SourceConfigure;
import com.chinadrtv.erp.user.handle.SalesSessionRegistry;
import com.chinadrtv.erp.user.service.SalesSessionService;
import com.chinadrtv.erp.user.util.SecurityHelper;
import com.chinadrtv.erp.util.StringUtil;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * User: liuhaidong
 * Date: 12-11-20
 */
@Controller
public class LoginController extends BaseController {
     private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private SourceConfigure sourceConfigure;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "login/login";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Map login(User user) {
        Map result = new HashMap();
        if ("admin".equals(user.getUsername()) &&
                "123456".equals(user.getPassword())) {
            result.put("code", 0);
        } else {
            result.put("code", -1);
            result.put("msg", "登录错误");
        }
        return result;
    }
}
