<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sales-登录</title>


    <link href="${ctx}/static/style/login.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
    <%--<script type="text/javascript" src="${ctx}/static/js/login.js"></script>--%>
    <script type="text/javascript">
        if (window != top) top.location.href = location.href;

        function formSubmit() {
            $.ajax({
                type: "post",
                async: false,
                cache: false,
                url: "/submit",
                dataType: "json",
                data: {username: $('#username').val(), password: $('#password').val(), agentNo: $('#agentNo').val()},
                success: function (data) {
                    if (data.code == 0) {
                        window.location.href = "/index";
                    } else {
                        $("#loginError").html(data.msg);
                    }
                }
            });
        }
    </script>
</head>

<body>
<div id="login">
    <div id="login_wrapper">
        <div id="right_side">
            <div id="login_component">
                <div id="logo_wrapper"><img id="logo" class="logo_repository"
                                            src="/static/images/logo_sales.png"
                                            border="0"/>
                </div>
                <div id="loginwidget">
                    <form name="login" autocomplete="off" novalidate="novalidate" target="_top">
                        <div id="loginError" class="loginError"></div>

                        <div class="loginbox_container">
                            <div id="usrn">
                                <div><label for="username" class="zen-assistiveText">坐席工号</label>
                                    <input id="username" placeholder="坐席工号" name="username" type="text" tabindex="1"
                                           class="input"/>
                                </div>
                            </div>
                        </div>

                        <div class="loginbox_container">
                            <div id="pswd">
                                <div><label for="password" class="zen-assistiveText">密码</label>
                                    <input type="password" placeholder="密码" name="password" id="password" tabindex="2"
                                           class="input"/>
                                </div>
                            </div>
                        </div>

                        <div class="loginbox_container">
                            <button type="button" onclick="formSubmit();" class="button" id="LoginButton" name="Login"><span class="label">登&nbsp;&nbsp;&nbsp;录</span>
                            </button>
                        </div>

                        <div class="loginbox_container">
                            <div id="ano">
                                <div><label for="agentNo" class="zen-assistiveText">分机号</label>
                                    <input id="agentNo" placeholder="分机号" name="agentNo" type="text" tabindex="1"
                                           class="input"/>
                                </div>
                            </div>
                        </div>

                        <div class="loginbox_container">
                            <div id="rem" class="wrapper_remember"><input type="checkbox" checked="checked"
                                                                          id="softphone" name="softphone">
                                &nbsp;<label for="softphone">加载软电话</label></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="left_side">
            <div id="marketing">
                <img src="/static/images/login_sales.jpg"/>

            </div>
        </div>
    </div>
    <div id="footer">Copyright © 2016 seezero.com, inc. 公司版权所有。保留所有权利。</div>
</div>
</body>
</html>
