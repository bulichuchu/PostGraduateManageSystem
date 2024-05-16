<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://xmlns.jcp.org/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学籍信息</title>
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
            padding: 20px;
        }
        .info-table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
        }
        .info-table th, .info-table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .info-table th {
            background-color: #f2f2f2;
        }
        .info-section {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="logo_1">
        <img src="/img/logo_jw_d.png" alt="学校Logo">
        <span id="xtmc">浙江工业大学正方教务管理系统</span>
    </div>
</div>
<div class="container">
    <div class="info-section">
        <h2>基本信息</h2>
        <table class="info-table">
            <tr>
                <th>学号</th>
                <td>${user.studentId}</td>
                <th>姓名</th>
                <td>${user.name}</td>
            </tr>
            <tr>
                <th>性别</th>
                <td>${user.gender}</td>
                <th>姓名拼音</th>
                <td>${user.pinYin}</td>
            </tr>
            <tr>
                <th>籍贯</th>
                <td>${user.ethnicGroup}</td>
                <th>出生日期</th>
                <td>${user.birthDate}</td>
            </tr>
            <tr>
                <th>证件号码</th>
                <td>${user.idNumber}</td>
                <th>证件类型</th>
                <td>${user.idType}</td>
            </tr>
            <tr>
                <th>出生地</th>
                <td>${user.birthPlace}</td>
                <th>婚姻状况</th>
                <td>${user.maritalStatus}</td>
            </tr>
            <tr>
                <th>家庭地址</th>
                <td>${user.address}</td>
                <th>生源地</th>
                <td>${user.birthRegion}</td>
            </tr>
            <tr>
                <th>户口所在地详细地址</th>
                <td>${user.domicileAddress}</td>
                <th>户口所在地</th>
                <td>${user.domicileRegion}</td>
            </tr>
            <tr>
                <th>火车起点站</th>
                <td>${user.trainOrigin}</td>
                <th>户口所在地邮编</th>
                <td>${user.domicileZipCode}</td>
            </tr>
            <tr>
                <th>校内电子邮箱</th>
                <td>${user.schoolEmail}</td>
                <th>手机号码</th>
                <td>${user.phoneNumber}</td>
            </tr>
            <tr>
                <th>学生标签</th>
                <td>${user.studentTag}</td>
                <th>入党日期</th>
                <td>${user.partyDate}</td>
            </tr>
            <tr>
                <th>奖励情况</th>
                <td colspan="3">${user.awards}</td>
            </tr>
            <tr>
                <th>政治面貌</th>
                <td colspan="3">${user.politicalStatus}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
