<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>教务管理系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header img {
            height: 50px;
        }
        .header #xtmc {
            font-size: 24px;
            margin-left: 10px;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 80px);
            flex-wrap: wrap;
            padding: 20px;
        }
        .login-container {
            width: 400px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 40px;
            margin: 10px;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-form input[type="text"],
        .login-form input[type="password"],
        .login-form input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .login-form input[type="submit"] {
            background-color: #007bff;
            border: none;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .login-form input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            margin-bottom: 20px;
            text-align: center;
        }
        .login-image {
            flex: 1;
            text-align: center;
            margin: 10px;
        }
        .login-image img {
            max-width: 100%;
            height: auto;
        }
        .register-link {
            text-align: center;
            margin-top: 20px;
        }
        .register-link a {
            color: #007bff;
            text-decoration: none;
            margin: 0 5px;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<%
    String imageUrl = "/IMG/pic1.jpg"; // 设置图片的URL
%>
<div class="header">
    <div class="logo_1">
        <img src="/IMG/logo_jw_d.png" alt="学校Logo">
        <span id="xtmc">浙江工业大学正方教务管理系统</span>
    </div>
</div>
<div class="container">
    <div class="login-image">
        <img src="<%=imageUrl%>" alt="登录图片">
    </div>
    <div class="login-container">
        <h2>教务管理系统</h2>
<%--        &lt;%&ndash; 显示错误信息 &ndash;%&gt;--%>
<%--        <c:if test="${not empty sessionScope.message}">--%>
<%--            <div class="error-message">${sessionScope.message}</div>--%>
<%--        </c:if>--%>
        <form class="login-form" action="<%=request.getContextPath()%>/loginChangeServlet" method="post">
            <input type="hidden" name="token" value="<%=new Date().getTime()%>"/>
            <input type="text" name="username" placeholder="请输入账号" required />
            <input type="password" name="password" placeholder="请输入密码" required/>
            <input type="submit" name="submit" value="登录" />
        </form>
        <div class="register-link">
            <a href="findpassword.jsp">忘记密码？</a> | <a href="register.jsp">立即注册</a>
        </div>
    </div>
</div>
</body>
</html>
