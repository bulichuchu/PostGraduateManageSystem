<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Review Information</title>
</head>
<body>
<h1>Review Information</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <!-- 其他信息的表头 -->
    </tr>
    </thead>
    <tbody>
    <!-- 遍历信息列表，显示每个条目的信息 -->
    <%--@elvariable id="infoList" type="com.example.postgraduatemanagesystem.servlet.ReviewInfoServlet"--%>
    <c:forEach items="${infoList}" var="info">
        <tr>
            <td>${info.id}</td>
            <td>${info.name}</td>
            <!-- 其他信息的表格列 -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
