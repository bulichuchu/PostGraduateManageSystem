package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.bean.BasicInfo;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ReviewInfoServlet")
public class ReviewInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String reviewerID = (String) session.getAttribute("studentID");

        // 在服务器上存储信息的目录路径
        String directoryPath = "/path/to/directory"; // 修改为服务器上实际的目录路径

        // 获取存储在目录下的所有文件
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // 假设文件名即为待审核的信息ID
        // 创建一个列表存储信息
        List<BasicInfo> infoList = new ArrayList<>();

        // 遍历文件列表，读取文件内容并将信息存储到列表中
        for (File file : files) {
            // 读取文件内容并解析为 BasicInfo 对象
            BasicInfo info = readInfoFromFile(file);
            infoList.add(info);
        }

        // 将信息列表存储在请求属性中
        request.setAttribute("infoList", infoList);

        // 转发到审核页面
        request.getRequestDispatcher("reviewInfo.jsp").forward(request, response);
    }

    // 从文件中读取信息并解析为 BasicInfo 对象的方法
    private BasicInfo readInfoFromFile(File file) {

        Gson gson = new Gson();
        BasicInfo info = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // 读取文件内容
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            // 将文件内容解析为 BasicInfo 对象
            info = gson.fromJson(sb.toString(), BasicInfo.class);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return info;
    }
}
