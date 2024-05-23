<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>信息审核</title>
</head>
<body>
<h1>信息审核</h1>

<table border="1">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>姓名拼音</th>
        <th>性别</th>
        <th>民族</th>
        <th>出生日期</th>
        <th>籍贯</th>
        <th>政治面貌</th>
        <th>证件号码</th>
        <th>证件类型</th>
        <th>婚姻状况</th>
        <th>生源地</th>
        <th>家庭地址</th>
        <th>手机号码</th>
        <th>校内电子邮箱</th>
        <th>宿舍号</th>
        <th>入党日期</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="infoList" scope="request" type="java.util.List<com.example.postgraduatemanagesystem.bean.BasicInfo>"/>
    <c:forEach items="${infoList}" var="info">
        <tr>
            <td>${info.studentID}</td>
            <td>${info.name}</td>
            <td>${info.namePY}</td>
            <td>${info.gender}</td>
            <td>${info.nation}</td>
            <td>${info.birthDate}</td>
            <td>${info.nativePlace}</td>
            <td>${info.politicalStatus}</td>
            <td>${info.IDNumber}</td>
            <td>${info.IDType}</td>
            <td>${info.maritalStatus}</td>
            <td>${info.birthPlace}</td>
            <td>${info.familyAddress}</td>
            <td>${info.phoneNumber}</td>
            <td>${info.campusEmail}</td>
            <td>${info.personalEmail}</td>
            <td>${info.joinPartyDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
