<%@ page import="com.example.postgraduatemanagesystem.bean.BasicInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>审核信息</title>
    <script type="text/javascript">
        // 页面加载时检查是否更新成功并显示提示框
        function showSuccessMessage() {
            <% Boolean updateSuccess = (Boolean) session.getAttribute("updateSuccess");
               if (updateSuccess != null && updateSuccess) { %>
            alert("信息修改成功！");
            <% session.removeAttribute("updateSuccess"); %>
            <% } %>
        }

        document.getElementById('submit').onclick = showSuccessMessage;
    </script>
</head>
<body>
<h1>信息审核</h1>



<form action="ProcessReviewedInfoServlet" method="post">
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
    <% List<BasicInfo> infoList = (List<BasicInfo>) request.getAttribute("infoList");
        if (infoList != null && !infoList.isEmpty()) {
            for (BasicInfo info : infoList) { %>
        <tr>
            <td><%= info.getStudentID()%></td>
            <td><%= info.getNamePY() %></td>
            <td><%= info.getGender() %></td>
            <td><%= info.getNation() %></td>
            <td><%= info.getBirthDate() %></td>
            <td><%= info.getNativePlace() %></td>
            <td><%= info.getPoliticalStatus() %></td>
            <td><%= info.getIDNumber() %></td>
            <td><%= info.getIDType() %></td>
            <td><%= info.getMaritalStatus() %></td>
            <td><%= info.getBirthPlace() %></td>
            <td><%= info.getFamilyAddress() %></td>
            <td><%= info.getPhoneNumber() %></td>
            <td><%= info.getCampusEmail() %></td>
            <td><%= info.getPersonalEmail() %></td>
            <td><%= info.getJoinPartyDate() %></td>
        </tr>
        <% }
       } else { %>
    <tr>
        <td colspan="7">没有待审核的信息</td>
    </tr>
        <% } %>
</table>
    <input type="submit" value="同意变更">
</form>
</body>
</html>
