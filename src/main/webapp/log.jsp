<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Log Viewer</title>
</head>
<body>
<h1>Log Viewer</h1>
<pre>
        <%
            try {
                // 指定日志文件路径
                String logFilePath = "D:\\IdeaProjects\\PostGraduateManageSystem\\app.log";
                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(logFilePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    out.println(line + "<br>");
                }
                reader.close();
            } catch (Exception e) {
                out.println("Error reading log file: " + e.getMessage());
            }
        %>
    </pre>
</body>
</html>
