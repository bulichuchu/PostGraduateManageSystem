<%--@elvariable id="basicInfo" type="com.example.postgraduatemanagesystem.bean.BasicInfo"--%>
<%--@elvariable id="admissionInfo" type="com.example.postgraduatemanagesystem.bean.AdmissionInfo"--%>
<%--@elvariable id="extensionInfo" type="com.example.postgraduatemanagesystem.bean.ExtendedInfo"--%>
<%--@elvariable id="educationExperience" type="com.example.postgraduatemanagesystem.bean.EducationExperience"--%>
<%--@elvariable id="workExperience" type="com.example.postgraduatemanagesystem.bean.WorkExperience"--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        .tabs {
            display: flex;
            border-bottom: 2px solid #007bff;
            margin-bottom: 20px;
        }
        .tabs a {
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none;
            color: #007bff;
            border-bottom: 2px solid transparent;
        }
        .tabs a.active {
            border-bottom: 2px solid #007bff;
            font-weight: bold;
        }
        .content-section {
            display: none;
        }
        .content-section.active {
            display: block;
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
    <script>
        function showSection(sectionId) {
            var sections = document.querySelectorAll('.content-section');
            var tabs = document.querySelectorAll('.tabs a');
            sections.forEach(function(section) {
                section.classList.remove('active');
            });
            tabs.forEach(function(tab) {
                tab.classList.remove('active');
            });
            document.getElementById(sectionId).classList.add('active');
            document.querySelector('.tabs a[href="#' + sectionId + '"]').classList.add('active');
        }

        document.addEventListener('DOMContentLoaded', function() {
            showSection('basic-info'); // 默认显示基础信息
        });
    </script>
</head>
<body>
<div class="header">
    <div class="logo_1">
        <img src="${pageContext.request.contextPath}/IMG/logo_jw_d.png" alt="学校Logo">
        <span id="xtmc">浙江工业大学教务管理系统</span>
    </div>
</div>
<div class="container">
    <div class="tabs">
        <a href="#basic-info" class="active" onclick="showSection('basic-info'); return false;">基础信息</a>
        <a href="#admission-info" onclick="showSection('admission-info'); return false;">入学信息</a>
        <a href="#extended-info" onclick="showSection('extended-info'); return false;">扩展信息</a>
    </div>
    <div id="basic-info" class="content-section active">
        <h2>基础信息</h2>
        <table class="info-table">
            <tr>
                <th>学号</th>
                <td>${basicInfo.studentID}</td>
                <th>姓名</th>
                <td>${basicInfo.name}</td>
                <th>姓名拼音</th>
                <td>${basicInfo.namePY}</td>
            </tr>
            <tr>
                <th>性别</th>
                <td>${basicInfo.gender}</td>
                <th>民族</th>
                <td>${basicInfo.nation}</td>
                <th>出生日期</th>
                <td>${basicInfo.birthDate}</td>
            </tr>
            <tr>
                <th>籍贯</th>
                <td>${basicInfo.nativePlace}</td>
                <th>政治面貌</th>
                <td>${basicInfo.politicalStatus}</td>
                <th>证件类型</th>
                <td>${basicInfo.IDType}</td>
            </tr>
            <tr>
                <th>证件号码</th>
                <td>${basicInfo.IDNumber}</td>
                <th>国家地区</th>
                <td>${basicInfo.country}</td>
                <th>婚姻状况</th>
                <td>${basicInfo.maritalStatus}</td>
            </tr>
            <tr>
                <th>出生地</th>
                <td>${basicInfo.birthPlace}</td>
                 <th>生源地</th>
                <td>${basicInfo.originPlace}</td>
            <tr>
                <th>家庭地址</th>
                <td>${basicInfo.familyAddress}</td>
            <th>户口所在地</th>
            <td>${basicInfo.huKouPlace}</td>


            </tr>
            <tr>
                <th>户口所在地详细地址</th>
                <td>${basicInfo.huKouDetailedPlace}</td>
                <th>户口所在地邮编</th>
                <td>${basicInfo.huKouPostalCode}</td>

            </tr>
            <tr>
                <th>火车起点站</th>
                <td>${basicInfo.railwayStationStart}</td>
                <th>火车终点站</th>
                <td>${basicInfo.railwayStationEnd}</td>

                <th>手机号码</th>
                <td>${basicInfo.phoneNumber}</td>
            </tr>
            <tr>
                <th>校内电子邮箱</th>
                <td>${basicInfo.campusEmail}</td>
                <th>电子邮箱</th>
                <td>${basicInfo.personalEmail}</td>

                <th>入党日期</th>
                <td>${basicInfo.joinPartyDate}</td>
            </tr>
            <tr>
                <th>学生标签</th>
                <td>${basicInfo.studentLabel}</td>

                <th>宿舍号</th>
                <td>${basicInfo.personalEmail}</td>
            </tr>
            <tr>
                <th>奖励情况</th>
                <td>${basicInfo.award}</td>
                </tr>
        </table>
        <h2>在校信息</h2>
        <table class="info-table">
            <tr>
                <th>年级</th>
                <td>${basicInfo.grade}</td>
                <th>入学季节</th>
                <td>${basicInfo.entranceSeason}</td>
                <th>培养层次</th>
                <td>${basicInfo.cultivationLevel}</td>
            </tr>
            <tr>
                <th>学生类别</th>
                <td>${basicInfo.studentCategory}</td>
                <th>学院</th>
                <td>${basicInfo.college}</td>
                <th>管理单位</th>
                <td>${basicInfo.managementDepartment}</td>
            </tr>
            <tr>
                <th>专业</th>
                <td>${basicInfo.major}</td>
                <th>学制</th>
                <td>${basicInfo.lengthOfSchooling}</td>
                <th>入学方式</th>
                <td>${basicInfo.entranceMethod}</td>
            </tr>
            <tr>
                <th>校区</th>
                <td>${basicInfo.campusZone}</td>
                <th>入学年月</th>
                <td>${basicInfo.entranceDate}</td>
<th>班级</th>
                <td>${basicInfo.studentClass}</td>

            </tr>

            <tr>
                <th>招生专业</th>
                <td>${basicInfo.enrollmentMajor}</td>
                <th>门类/学业学位类别</th>
                <td>${basicInfo.degreeCategory}</td>
                <th>学位类型</th>
                <td>${basicInfo.degreeType}</td>
            </tr>
            <tr>
                <th>专业方向</th>
                <td>${basicInfo.majorWay}</td>
                <th>培养方式</th>
                <td>${basicInfo.cultureMethod}</td>
                <th>学习方式</th>
                <td>${basicInfo.studyMethod}</td>
            </tr>
            <tr><th>进修性质</th>
                <td>${basicInfo.jinXiuCategory}</td>
                <th>专项计划</th>
                <td>${basicInfo.specialPlan}</td>
                <th>预计毕业时间</th>
                <td>${basicInfo.expectedGraduationTime}</td>

            </tr>
            <tr><th>联合培养单位名称</th>
                <td>${basicInfo.jointTrainingUnit}</td>
                <th>是否跨学科</th>
                <td>${basicInfo.interdisciplinary}</td>
                <th>是否留学生</th>
                <td>${basicInfo.overseas}</td>

            </tr>
            <tr>
                <th>实际毕业时间</th>
                <td>${basicInfo.actualGraduationTime}</td>
                <th>学籍状态</th>
                <td>${basicInfo.studentStatus}</td>
                <th>学籍异动状态</th>
                <td>${basicInfo.studentStatusChangeStatus}</td>
            </tr>
            <tr>
                <th>导师</th>
                <td>${basicInfo.mentor}</td>
                <th>导师2</th>
                <td>${basicInfo.mentor2}</td>
                <th>联合培养导师</th>
                <td>${basicInfo.jointTrainingMentors}</td>
            </tr>
            <tr>
                <th>在校标识</th>
                <td>${basicInfo.onCampus}</td>
                <th>研究方向</th>
                <td>${basicInfo.researchDirection}</td>
                <th>注册状态</th>
                <td>${basicInfo.registrationStatus}</td>
            </tr>
            <tr>
                <th>缴费情况</th>
                <td>${basicInfo.paymentStatus}</td>
                <th>学位</th>
                <td>${basicInfo.degrees}</td>
                <th>是否接受学历教育</th>
                <td>${basicInfo.receiveAcademicEducation}</td>
            </tr>
            <tr>
                <th>学位情况</th>
                <td>${basicInfo.degreeStatus}</td>
                <th>一级学科/专业学位类别</th>
                <td>${basicInfo.professionalDegreeCategory}</td>
                <th>是否学科交叉培养</th>
                <td>${basicInfo.interdisciplinaryTraining}</td>
            </tr>
            <tr>
                <th>交叉培养学科</th>
                <td>${basicInfo.interdisciplinaryTrainingDiscipline}</td>
                <th>学位授予时间</th>
                <td>${basicInfo.dateOfDegreeAward}</td>
            </tr>
        </table>
    </div>
    <div id="admission-info" class="content-section">
        <h2>入学信息</h2>

        <table class="info-table">
            <tr>
                <th>招生年度</th>
                <td>${admissionInfo.enrollmentYear}</td>
                <th>考生编号</th>
                <td>${admissionInfo.candidateID}</td>
                <th>报考类别</th>
                <td>${admissionInfo. applicationCategory}</td>
            </tr>
            <tr>
                <th>考生来源</th>
                <td>${admissionInfo.candidateSource}</td>
                <th>录取类别</th>
                <td>${admissionInfo.admissionCategory}</td>
                <th>考试方式</th>
                <td>${admissionInfo.examinationMethods}</td>
            </tr>
            <tr>
                <th>是否保送</th>
                <td>${admissionInfo.returnStatus}</td>
                <th>保留入学资格年限</th>
                <td>${admissionInfo.retentionQualificationYears}</td>
                <th>定向委培单位所在地</th>
                <td>${admissionInfo.targetedTrainingUnitsPlace}</td>
            </tr>
            <tr>
                <th>定向委培单位</th>
                <td><"${admissionInfo.targetedTrainingUnits}/></td>
                <th>推免单位</th>
                <td>${admissionInfo.recommendedUnit}</td>
            </tr>
            <!-- 其他入学信息字段 -->
        </table>

        <h2>入学前学历信息</h2>
        <table class="info-table">
            <tr>
                <th>最后毕业学校</th>
                <td>${admissionInfo.finalGraduationSchool}</td>
                <th>最后毕业学校名称</th>
                <td>${admissionInfo.finalGraduationSchoolName}</td>
            </tr>
            <tr>
                <th>最后毕业专业</th>
                <td>${admissionInfo.finalGraduationMajor}</td>
                <th>最后毕业专业名称</th>
                <td>${admissionInfo.finalGraduationMajorName}</td>
                <th>最后学历单位</th>
                <td>${admissionInfo.lastDegreeUnit}</td>
            </tr>
            <tr>
                <th>最后学位单位名称</th>
                <td>${admissionInfo. finalGraduationSchoolName}</td>
                <th>最后学位专业</th>
                <td>${admissionInfo.finalGraduationMajor}</td>
                <th>最后学历专业名称</th>
                <td>${admissionInfo.finalGraduationMajorName}</td>
            </tr>
            <tr>
                <th>最后毕业证书编号</th>
                <td>${admissionInfo.finalGraduationCertificateNumber}</td>
                <th>最后学历</th>
                <td>${admissionInfo.finalEducation}</td>
            </tr>
            <tr>
                <th>最后学位</th>
                <td>${admissionInfo.finalDegree}</td>
                <th>最后毕业时间</th>
                <td><"${admissionInfo.finalGraduationDate}"/></td>
                <th>最后学位时间</th>
                <td><"${admissionInfo.finalDegreeDate}"/></td>
            </tr>
            <tr>
                <th>最后学历学习形式</th>
                <td>${admissionInfo.finalAcademicLearningForm}</td>
            </tr>
        </table>
    </div>
            <div id="extended-info" class="content-section">
                <h2>扩展信息</h2>
                <table class="info-table">
                    <tr>
                        <th>微信号</th>
                        <td>${extensionInfo.wxID}</td>
                        <th>QQ</th>
                        <td>${extensionInfo.qqID}</td>
                        <th>联系电话</th>
                        <td>${extensionInfo.phone}</td>
                    </tr>
                    <tr>
                        <th>通讯地址</th>
                        <td colspan="3">${extensionInfo.address}</td>
                        <th>邮政编码</th>
                        <td>${extensionInfo.postCode}</td>
                    </tr>
                    <tr>
                        <th>现就学习或工作单位</th>
                        <td>${extensionInfo.studyUnit}</td>
                        <th>单位电话</th>
                        <td>${extensionInfo.unitPhone}</td>
                        <th>单位邮编</th>
                        <td>${extensionInfo.unitPostCode}</td>
                    </tr>
                    <tr>
                        <th>现就学习或工作单位地址</th>
                        <td colspan="3">${extensionInfo.unitAddress}</td>
                    </tr>
                    <tr>
                        <th>紧急联系人</th>
                        <td>${extensionInfo.emergencyContact}</td>
                        <th>紧急电话</th>
                        <td>${extensionInfo.emergencyPhone}</td>
                        <th>紧急联系人邮政编码</th>
                        <td>${extensionInfo.emergencyPostCode}</td>
                    </tr>
                    <tr>
                        <th>紧急联系人住址</th>
                        <td colspan="3">${extensionInfo.emergencyAddress}</td>
                    </tr>
                    <tr>
                        <th>宿舍地址</th>
                        <td>${extensionInfo.dormitoryAddress}</td>
                        <th>宿舍电话</th>
                        <td>${extensionInfo.dormitoryPhone}</td>
                        <th>专业技术职务</th>
                        <td>${extensionInfo.technicalPosition}</td>
                    </tr>
                    <tr>
                        <th>行政职务级别</th>
                        <td>${extensionInfo.administrativePositionLevel}</td>
                        <th>家庭所在地</th>
                        <td>${extensionInfo.familyAddress}</td>
                        <th>家庭邮政编码</th>
                        <td>${extensionInfo.familyPostCode}</td>
                    </tr>
                    <tr>
                        <th>家庭电话</th>
                        <td>${extensionInfo.familyPhone}</td>
                        <th>家庭联系人</th>
                        <td>${extensionInfo.familyContact}</td>
                    </tr>
                </table>

                <h2>工作经历</h2>
                <table class="info-table">
                    <thead>
                    <tr>
                        <th>起始日期</th>
                        <th>结束日期</th>
                        <th>所在单位</th>
                        <th>从事工作</th>
                        <th>担任职务</th>
                        <th>证明人</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${workExperience.startTime}</td>
                        <td>${workExperience.endTime}</td>
                        <td>${workExperience.workUnit}</td>
                        <td>${workExperience.workPosition}</td>
                        <td>${workExperience.provePerson}</td>
                        <td>${workExperience.notes}</td>
                    </tr>
                    <!-- 可以添加更多的工作经历记录 -->
                    </tbody>
                </table>


                <%--    <div id="education-experience" class="content-section">--%>
                <h2>教育经历</h2>
                <table class="info-table">
                    <thead>
                    <tr>
                        <th>学校名称</th>
                        <th>起始日期</th>
                        <th>结束日期</th>
                        <th>专业名称</th>
                        <th>专业描述</th>
                        <th>学历</th>
                        <th>学位类型</th>
                        <th>毕业学校地点</th>
                        <th>修学年限</th>
                        <th>是否毕业</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${educationExperience.schoolName}</td>
                        <td>${educationExperience.startTime}</td>
                        <td>${educationExperience.endTime}</td>
                        <td>${educationExperience.major}</td>
                        <td>${educationExperience.majorDescription}</td>
                        <td>${educationExperience.degreeType}</td>
                        <td>${educationExperience.graduatePosition}</td>
                        <td>${educationExperience.restTime}</td>
                        <td>${educationExperience.isGraduate}</td>
                    </tr>
                    <!-- 可以添加更多的教育经历记录 -->
                    </tbody>
                </table>
            </div>


</div>
</body>
</html>
