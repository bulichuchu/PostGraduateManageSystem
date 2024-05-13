-- 插入基本信息
INSERT INTO BasicInfo (StudentID, Name, Name_PY, Gender, nation, BirthDate, native_place, political_status, ID_type,
                       ID_number, country, marital_status, BirthPlace, origin_place, family_address, HuKou_place,
                       HuKou_detailed_place, HuKou_postal_code, Railway_Station_start, Railway_Station_end,
                       phone_number, campus_email, personal_email, Join_party_date, student_label, department_ID, award,
                       grade, entrance_season, Cultivation_level, Student_category, college, management_department,
                       major, length_of_schooling, entrance_method, campus_zone, entrance_date, class, Enrollment_major,
                       Degree_Category, Degree_type, major_way, culture_method, study_method, JinXiu_category,
                       special_plan, Expected_graduation_time, Joint_Training_Unit, interdisciplinary, overseas,
                       Actual_graduation_time, Student_status, Student_status_change_status, mentor, mentor2,
                       Joint_training_mentors, On_campus, Research_Direction, Registration_Status, Payment_status,
                       degrees, receive_academic_education, degree_status, professional_degree_category,
                       Interdisciplinary_training, Interdisciplinary_training_discipline, Date_of_degree_award)
VALUES (1, N'张三', N'Zhang San', N'男', N'汉族', '1998-05-25', N'北京', N'党员', N'身份证', N'110101199805250011',
        N'中国', N'未婚', N'北京', N'北京', N'北京', N'北京', N'东城区', N'100010', N'北京火车站', N'上海火车站',
        N'13812345678', N'zhangsan@university.edu', N'zhangsan@gmail.com', '2017-06-01', N'大一', N'001', N'优秀学生奖',
        N'A', N'春季', N'硕士研究生', N'全日制专业学位硕士', N'计算机科学与技术学院', N'浙江工业大学', N'软件工程专业',
        N'3年',
        N'全国统考', N'屏峰校区', '2017-09-01', N'CS101', N'软件工程', N'软件工程', N'专业学位', N'cs', N'非定向',
        N'全日制',
        N'校内进修', N'无', '2021-06-30', N'无', N'否', N'否', '2021-06-30', N'正常', N'转专业', N'李四', N'无', N'无',
        N'在校',
        N'人工智能', N'已注册', N'已付款', N'学士', N'是', N'未获', N'计算机科学与技术', N'否', N'无', '2021-06-30');


-- 插入入学信息
INSERT INTO AdmissionInfo (StudentID, EnrollmentYear, CandidateID, ApplicationCategory, CandidateSource,
                           AdmissionCategory, ExaminationMethods, ReturnStatus, RetentionQualificationYears,
                           targetedTrainingUnits, targetedTrainingUnitsPlace, RecommendedUnit, FinalGraduationSchool,
                           FinalGraduationSchoolName, FinalGraduationMajor, FinalGraduationMajorName, LastDegreeUnit,
                           FinalGraduationCertificateNumber, FinalEducation, FinalDegree, FinalGraduationDate,
                           FinalDegreeDate, FinalAcademicLearningForm)
VALUES (1, 2012, 987654, N'普通入学', N'高考', N'统考录取', N'笔试', N'正常', 0, N'无', N'', N'学校推荐', N'北京大学',
        N'北京大学', N'计算机科学与技术', N'硕士研究生', N'学士学位', N'123456789', N'研究生', N'硕士', '2012-09-01',
        '2015-06-30', N'全日制');

-- 插入扩展信息
INSERT INTO ExtensionInfo (StudentID, WxID, QQID, Phone, Address, PostCode, StudyUnit, UnitPhone, UnitPostCode,
                           UnitAddress, EmergencyContact, EmergencyPhone, EmergencyPostCode, EmergencyAddress,
                           DormitoryAddress, DormitoryPhone, technicalPosition, AdministrativePositionLevel,
                           FamilyAddress, FamilyPostCode, FamilyPhone, FamilyContact)
VALUES (1, 'wx123456', 'qq987654', '13899998888', N'北京市朝阳区学院路甲1号', '100101', N'北京大学', '010-12345678',
        '100101', N'北京市海淀区中关村大街1号', N'王小明父亲', '13987654321', '100102', N'北京市朝阳区学院路甲1号',
        N'北京市朝阳区学院路甲1号', '010-87654321', N'高级工程师', N'副院长', N'北京市朝阳区学院路甲1号', '100101',
        '010-12345678', N'王小明父亲');

-- 插入工作经验
INSERT INTO WorkExperience (StudentID, startTime, endTime, workUnit, workCategory, WorkPosition, WorkDuty, provePerson,
                            notes)
VALUES (1, '2022-07-01', '2024-07-01', N'腾讯科技有限公司', N'技术类', N'软件工程师', N'负责软件开发与维护', N'王经理',
        N'无');

-- 插入教育经历
INSERT INTO EducationExperience (StudentID, SchoolName, startTime, endTime, major, majorDescription, degree, degreeType,
                                 graduatePosition, RestTime, IsGraduate)
VALUES (1, N'北京大学', '2012-09-01', '2015-06-30', N'计算机科学与技术', N'主要学习计算机编程、算法等相关课程', N'学士',
        N'工学学士', N'计算机科学与技术专业学士', N'无', '是');


-- 插入李四的基本信息
INSERT INTO BasicInfo (StudentID, Name, Name_PY, Gender, nation, BirthDate, native_place, political_status, ID_type,
                       ID_number, country, marital_status, BirthPlace, origin_place, family_address, HuKou_place,
                       HuKou_detailed_place, HuKou_postal_code, Railway_Station_start, Railway_Station_end,
                       phone_number, campus_email, personal_email, Join_party_date, student_label, department_ID, award,
                       grade, entrance_season, Cultivation_level, Student_category, college, management_department,
                       major, length_of_schooling, entrance_method, campus_zone, entrance_date, class, Enrollment_major,
                       Degree_Category, Degree_type, major_way, culture_method, study_method, JinXiu_category,
                       special_plan, Expected_graduation_time, Joint_Training_Unit, interdisciplinary, overseas,
                       Actual_graduation_time, Student_status, Student_status_change_status, mentor, mentor2,
                       Joint_training_mentors, On_campus, Research_Direction, Registration_Status, Payment_status,
                       degrees, receive_academic_education, degree_status, professional_degree_category,
                       Interdisciplinary_training, Interdisciplinary_training_discipline, Date_of_degree_award)
VALUES (2, N'李四', N'Li Si', N'男', N'汉族', '1999-03-15', N'上海', N'党员', N'身份证', N'310101199903150022',
        N'中国', N'未婚', N'上海', N'上海', N'上海', N'上海', N'黄浦区', N'200010', N'上海火车站', N'广州火车站',
        N'13987654321', N'lisi@university.edu', N'lisi@gmail.com', '2018-05-01', N'大二', N'002', N'三好学生奖',
        N'B', N'秋季', N'硕士研究生', N'全日制专业学位硕士', N'计算机科学与技术学院', N'浙江工业大学', N'软件工程专业',
        N'3年',
        N'全国统考', N'屏峰校区', '2018-09-01', N'CS102', N'软件工程', N'软件工程', N'专业学位', N'cs', N'非定向',
        N'全日制',
        N'校内进修', N'无', '2022-06-30', N'无', N'否', N'否', '2022-06-30', N'正常', N'转专业', N'王小明', N'无',
        N'无', N'在校',
        N'人工智能', N'已注册', N'已付款', N'学士', N'是', N'未获', N'计算机科学与技术', N'否', N'无', '2022-06-30');

-- 插入李四的入学信息
INSERT INTO AdmissionInfo (StudentID, EnrollmentYear, CandidateID, ApplicationCategory, CandidateSource,
                           AdmissionCategory, ExaminationMethods, ReturnStatus, RetentionQualificationYears,
                           targetedTrainingUnits, targetedTrainingUnitsPlace, RecommendedUnit, FinalGraduationSchool,
                           FinalGraduationSchoolName, FinalGraduationMajor, FinalGraduationMajorName, LastDegreeUnit,
                           FinalGraduationCertificateNumber, FinalEducation, FinalDegree, FinalGraduationDate,
                           FinalDegreeDate, FinalAcademicLearningForm)
VALUES (2, 2013, 876543, N'普通入学', N'高考', N'统考录取', N'笔试', N'正常', 0, N'无', N'', N'学校推荐', N'北京大学',
        N'北京大学', N'计算机科学与技术', N'硕士研究生', N'学士学位', N'987654321', N'研究生', N'硕士', '2013-09-01',
        '2016-06-30', N'全日制');

-- 插入李四的扩展信息
INSERT INTO ExtensionInfo (StudentID, WxID, QQID, Phone, Address, PostCode, StudyUnit, UnitPhone, UnitPostCode,
                           UnitAddress, EmergencyContact, EmergencyPhone, EmergencyPostCode, EmergencyAddress,
                           DormitoryAddress, DormitoryPhone, technicalPosition, AdministrativePositionLevel,
                           FamilyAddress, FamilyPostCode, FamilyPhone, FamilyContact)
VALUES (2, 'wx876543', 'qq123456', '13888889999', N'上海市黄浦区人民大道1号', '200001', N'北京大学', '010-98765432',
        '100000', N'北京市海淀区中关村大街1号', N'李小明父亲', '13876543210', '100002', N'上海市黄浦区人民大道1号',
        N'上海市黄浦区人民大道1号', '010-12348765', N'高级工程师', N'院长', N'上海市黄浦区人民大道1号', '200001',
        '010-98765432', N'李小明父亲');

-- 插入李四的教育经历
INSERT INTO EducationExperience (StudentID, SchoolName, startTime, endTime, major, majorDescription, degree, degreeType,
                                 graduatePosition, RestTime, IsGraduate)
VALUES (2, N'北京大学', '2013-09-01', '2016-06-30', N'计算机科学与技术', N'主要学习计算机编程、算法等相关课程', N'学士',
        N'工学学士', N'计算机科学与技术专业学士', N'无', '是');

-- 插入王五的基本信息
INSERT INTO BasicInfo (StudentID, Name, Name_PY, Gender, nation, BirthDate, native_place, political_status, ID_type,
                       ID_number, country, marital_status, BirthPlace, origin_place, family_address, HuKou_place,
                       HuKou_detailed_place, HuKou_postal_code, Railway_Station_start, Railway_Station_end,
                       phone_number, campus_email, personal_email, Join_party_date, student_label, department_ID, award,
                       grade, entrance_season, Cultivation_level, Student_category, college, management_department,
                       major, length_of_schooling, entrance_method, campus_zone, entrance_date, class, Enrollment_major,
                       Degree_Category, Degree_type, major_way, culture_method, study_method, JinXiu_category,
                       special_plan, Expected_graduation_time, Joint_Training_Unit, interdisciplinary, overseas,
                       Actual_graduation_time, Student_status, Student_status_change_status, mentor, mentor2,
                       Joint_training_mentors, On_campus, Research_Direction, Registration_Status, Payment_status,
                       degrees, receive_academic_education, degree_status, professional_degree_category,
                       Interdisciplinary_training, Interdisciplinary_training_discipline, Date_of_degree_award)
VALUES (3, N'王五', N'Wang Wu', N'男', N'汉族', '1997-08-20', N'广州', N'群众', N'护照', N'440101199708200011',
        N'中国', N'已婚', N'广州', N'广州', N'广州', N'广州', N'越秀区', N'300020', N'广州火车站', N'深圳火车站',
        N'13666667777', N'wangwu@university.edu', N'wangwu@gmail.com', '2016-09-01', N'大四', N'003', N'优秀毕业生奖',
        N'C', N'秋季', N'博士研究生', N'全日制学术型博士', N'计算机科学与技术学院', N'浙江工业大学', N'软件工程专业',
        N'5年',
        N'全国统考', N'屏峰校区', '2016-09-01', N'CS103', N'软件工程', N'软件工程', N'学术型', N'cs', N'非定向',
        N'全日制',
        N'校内进修', N'无', '2021-06-30', N'无', N'否', N'否', '2021-06-30', N'正常', N'转专业', N'赵小明', N'无',
        N'无', N'在校',
        N'人工智能', N'已注册', N'已付款', N'学士', N'是', N'未获', N'计算机科学与技术', N'否', N'无', '2021-06-30');

-- 插入王五的入学信息
INSERT INTO AdmissionInfo (StudentID, EnrollmentYear, CandidateID, ApplicationCategory, CandidateSource,
                           AdmissionCategory, ExaminationMethods, ReturnStatus, RetentionQualificationYears,
                           targetedTrainingUnits, targetedTrainingUnitsPlace, RecommendedUnit, FinalGraduationSchool,
                           FinalGraduationSchoolName, FinalGraduationMajor, FinalGraduationMajorName, LastDegreeUnit,
                           FinalGraduationCertificateNumber, FinalEducation, FinalDegree, FinalGraduationDate,
                           FinalDegreeDate, FinalAcademicLearningForm)
VALUES (3, 2011, 765432, N'普通入学', N'高考', N'统考录取', N'笔试', N'正常', 0, N'无', N'', N'学校推荐', N'北京大学',
        N'北京大学', N'计算机科学与技术', N'博士研究生', N'学士学位', N'654321987', N'研究生', N'博士', '2011-09-01',
        '2015-06-30', N'全日制');

-- 插入王五的扩展信息
INSERT INTO ExtensionInfo (StudentID, WxID, QQID, Phone, Address, PostCode, StudyUnit, UnitPhone, UnitPostCode,
                           UnitAddress, EmergencyContact, EmergencyPhone, EmergencyPostCode, EmergencyAddress,
                           DormitoryAddress, DormitoryPhone, technicalPosition, AdministrativePositionLevel,
                           FamilyAddress, FamilyPostCode, FamilyPhone, FamilyContact)
VALUES (3, 'wx765432', 'qq123987', '13666660000', N'广州市越秀区东风西路123号', '300010', N'北京大学', '010-12345678',
        '100000', N'北京市海淀区中关村大街1号', N'王小明母亲', '13912345678', '100002', N'广州市越秀区东风西路123号',
        N'广州市越秀区东风西路123号', '010-87654321', N'高级工程师', N'副校长', N'广州市越秀区东风西路123号', '300010',
        '010-12345678', N'王小明母亲');


-- 插入王五的教育经历
INSERT INTO EducationExperience (StudentID, SchoolName, startTime, endTime, major, majorDescription, degree, degreeType,
                                 graduatePosition, RestTime, IsGraduate)
VALUES (3, N'北京大学', '2011-09-01', '2015-06-30', N'计算机科学与技术', N'主要学习计算机编程、算法等相关课程', N'学士',
        N'工学学士', N'计算机科学与技术专业学士', N'无', '是');
