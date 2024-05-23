<%--@elvariable id="originalInfo" type="com.example.postgraduatemanagesystem.bean.BasicInfo"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学籍信息 - 修改基础信息</title>
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
    </style>
</head>
<body>
<div class="header">
    <h1>浙江工业大学正方教务管理系统</h1>
</div>
<div class="container">
    <div class="form-section">
        <h2 class="mb-4">修改基础信息</h2>
        <form action="changeInfoServlet" method="get">
            <div class="form-group row">
                <label for="studentID" class="col-sm-2 col-form-label">学号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="studentID" name="studentID" value="${originalInfo.studentID}" >
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${originalInfo.name}">
                </div>
            </div>
            <div class="form-group row">
                <label for="namePY" class="col-sm-2 col-form-label">姓名拼音</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="namePY" name="namePY" value="${originalInfo.namePY}">
                </div>
            </div>
            <div class="form-group row">
                <label for="gender" class="col-sm-2 col-form-label">性别</label>
                <div class="col-sm-10">
                    <select class="form-control" id="gender" name="gender">
                        <option value="男" ${originalInfo.gender == '男' ? 'selected' : ''}>男</option>
                        <option value="女" ${originalInfo.gender == '女' ? 'selected' : ''}>女</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="nation" class="col-sm-2 col-form-label">民族</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nation" name="nation" value="${originalInfo.nation}">
                </div>
            </div>
            <div class="form-group row">
                <label for="birthDate" class="col-sm-2 col-form-label">出生日期</label>
                <div class="col-sm-10">
                    <input type="Date" class="form-control" id="birthDate" name="birthDate" value="${originalInfo.birthDate}">
                </div>
            </div>
            <div class="form-group row">
                <label for="nativePlace" class="col-sm-2 col-form-label">籍贯</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nativePlace" name="nativePlace" value="${originalInfo.nativePlace}">
                </div>
            </div>
            <div class="form-group row">
                <label for="politicalStatus" class="col-sm-2 col-form-label">政治面貌</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="politicalStatus" name="politicalStatus" value="${originalInfo.politicalStatus}">
                </div>
            </div>
            <div class="form-group row">
                <label for="IDNumber" class="col-sm-2 col-form-label">证件号码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="IDNumber" name="IDNumber" value="${originalInfo.IDNumber}">
                </div>
            </div>
            <div class="form-group row">
                <label for="IDType" class="col-sm-2 col-form-label">证件类型</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="IDType" name="IDType" value="${originalInfo.IDType}">
                </div>
            </div>
            <div class="form-group row">
                <label for="maritalStatus" class="col-sm-2 col-form-label">婚姻状况</label>
                <div class="col-sm-10">
                    <select class="form-control" id="maritalStatus" name="maritalStatus">
                        <option value="未婚" ${originalInfo.maritalStatus == '未婚' ? 'selected' : ''}>未婚</option>
                        <option value="已婚" ${originalInfo.maritalStatus == '已婚' ? 'selected' : ''}>已婚</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="birthPlace" class="col-sm-2 col-form-label">生源地</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="birthPlace" name="birthPlace" value="${originalInfo.birthPlace}">
                </div>
            </div>
            <div class="form-group row">
                <label for="familyAddress" class="col-sm-2 col-form-label">家庭地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="familyAddress" name="familyAddress" value="${originalInfo.familyAddress}">
                </div>
            </div>
            <div class="form-group row">
                <label for="phoneNumber" class="col-sm-2 col-form-label">手机号码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${originalInfo.phoneNumber}">
                </div>
            </div>
            <div class="form-group row">
                <label for="campusEmail" class="col-sm-2 col-form-label">校内电子邮箱</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="campusEmail" name="campusEmail" value="${originalInfo.campusEmail}">
                </div>
            </div>
            <div class="form-group row">
                <label for="personalEmail" class="col-sm-2 col-form-label">宿舍号</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="personalEmail" name="personalEmail" value="${originalInfo.personalEmail}">
                </div>
            </div>
            <div class="form-group row">
                <label for="joinPartyDate" class="col-sm-2 col-form-label">入党日期</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="joinPartyDate" name="joinPartyDate" value="${originalInfo.joinPartyDate}">
                </div>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">保存修改</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
