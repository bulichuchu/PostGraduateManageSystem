<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 400px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group input:focus {
            border-color: #007BFF;
        }
        .form-group .hint {
            font-size: 12px;
            color: #999;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .message {
            text-align: center;
            color: red;
        }
    </style>
    <script>
        function validateForm() {
            var newPassword = document.getElementById("newPassword").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
            var message = "";

            var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{10,}$/;

            if (!passwordPattern.test(newPassword)) {
                message = "新密码必须包含大小写字母和数字，且不少于十位。";
            } else if (newPassword !== confirmPassword) {
                message = "新密码和确认密码不匹配！";
            }

            if (message !== "") {
                document.getElementById("error-message").innerText = message;
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <h2>修改密码</h2>
    <form action="ChangePasswordServlet" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="currentPassword">当前密码:</label>
            <input type="password" id="currentPassword" name="currentPassword" required>
        </div>
        <div class="form-group">
            <label for="newPassword">新密码:</label>
            <input type="password" id="newPassword" name="newPassword" required>
            <div class="hint">新密码必须包含大小写字母和数字，且不少于十位。</div>
        </div>
        <div class="form-group">
            <label for="confirmPassword">确认新密码:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <button type="submit" class="btn">提交</button>
    </form>
    <div class="message" id="error-message">
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.print(message);
            }
        %>
    </div>
</div>
</body>
</html>
