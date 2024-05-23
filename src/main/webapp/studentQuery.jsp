<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>教务领导查询学生信息</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 30px;
        }
        .header {
            background-color: #007bff;
            color: #fff;
            padding: 15px 20px;
            text-align: center;
        }
        .form-section {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .alert {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>浙江工业大学正方教务管理系统</h1>
</div>
<div class="container">
    <div class="form-section">
        <h2 class="mb-4">查询学生信息</h2>
        <form action="searchStudent" method="get">
            <div class="form-group row">
                <label for="studentID" class="col-sm-2 col-form-label">学号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="studentID" name="studentID" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">查询</button>
            </div>
        </form>
        <%--@elvariable id="errorMessage" type="com.example.postgraduatemanagesystem.servlet.studentQueryServlet"--%>
        <c:if test="${errorMessage}">
            <div class="alert alert-danger text-center">
                    ${errorMessage}
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
