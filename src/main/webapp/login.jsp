<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>教务管理系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f2ff; /* 淡蓝色背景 */
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
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            padding: 40px;
            margin: 10px;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
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
            font-size: 14px;
        }
        .login-form input[type="text"]:focus,
        .login-form input[type="password"]:focus {
            border-color: #007bff;
            box-shadow: 0 0 8px rgba(0, 123, 255, 0.2);
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
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="logo_1">
        <img src="${pageContext.request.contextPath}/IMG/logo_jw_d.png" alt="学校Logo">
        <span id="xtmc">浙江工业大学正方教务管理系统</span>
    </div>
</div>
<div class="container">
    <div class="login-image">
        <img src="${pageContext.request.contextPath}/IMG/pic1.jpg" alt="登录图片">
    </div>
    <div class="login-container">
        <h2>教务管理系统</h2>
        <form class="login-form" action="LoginServlet" method="post">
            <input type="hidden" name="token" value="<%=new Date().getTime()%>"/>
            <input type="text" name="userid" placeholder="请输入账号" required />
            <input type="password" name="password" placeholder="请输入密码" required/>
            <input type="submit" name="submit" value="登录" />
        </form>
        <div class="error-message">
            <%
                // 如果有错误消息，显示错误消息
                String message = (String) session.getAttribute("message");
                if (message != null) {
                    out.print(message);
                    session.removeAttribute("message");
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
