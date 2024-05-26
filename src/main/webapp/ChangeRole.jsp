<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Role Result</title>
    <script type="text/javascript">
        // 页面加载时检查是否修改成功并显示提示框
        window.onload = function() {
            <% Boolean changeRoleSuccess = (Boolean) request.getAttribute("changeRoleSuccess");
               if (changeRoleSuccess != null) { %>
            if (<%= changeRoleSuccess %>) {
                alert("角色修改成功！");
            } else {
                alert("角色修改失败！");
            }
            <% } %>
        };
    </script>
</head>
<body>

<h1>Change User Role</h1>

<form action="ChangeRoleServlet" method="post">
    <label for="userid">UserID:</label>
    <input type="text" id="userid" name="userid" required><br><br>

    <label for="newRole">New Role:</label>
    <select id="newRole" name="newRole" required>
        <option value="研究生">研究生</option>
        <option value="导师">导师</option>
        <option value="研究生院领导">研究生院领导</option>
        <option value="学校领导">学校领导</option>
        <option value="学院研究生秘书">学院研究生秘书</option>
        <option value="学院领导">学院领导</option>
        <option value="研究生院管理员">研究生院管理员</option>
        <option value="系统管理员">系统管理员</option>
        <option value="审计管理员">审计管理员</option>
    </select><br><br>

    <input type="submit" value="Change Role">
</form>

</body>
</html>
