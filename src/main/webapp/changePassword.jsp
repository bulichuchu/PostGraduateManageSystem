<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Change Password Page</title>
</head>
<body>
<h2>Change Password</h2>
<form method="post" action="ChangePasswordServlet">
    <input type="hidden" name="username" value="<%= request.getParameter("username") %>">
    <label for="newPassword">New Password:</label>
    <input type="password" id="newPassword" name="newPassword" required><br><br>
    <input type="submit" value="Change Password">
</form>
<% if (request.getParameter("error") != null) { %>
<p style="color:red;">Password change failed!</p>
<% } %>
</body>
