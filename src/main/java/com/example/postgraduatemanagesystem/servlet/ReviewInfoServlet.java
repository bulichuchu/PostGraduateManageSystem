package com.example.postgraduatemanagesystem.servlet;

import com.example.postgraduatemanagesystem.bean.BasicInfo;
import com.google.gson.*;
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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 在服务器上存储信息的目录路径
        String directoryPath = "C:\\Users\\yx\\IdeaProjects\\PostGraduateManageSystem\\ChangInfoJson\\"; // 修改为服务器上实际的目录路径

        // 获取存储在目录下的所有文件
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // 假设文件名即为待审核的信息ID
        // 创建一个列表存储信息
        List<BasicInfo> infoList = new ArrayList<>();

        // 遍历文件列表，读取文件内容并将信息存储到列表中
        if (files != null) {
            for (File file : files) {
                // 读取文件内容并解析为 BasicInfo 对象
                BasicInfo info = readInfoFromFile(file);
                infoList.add(info);
            }
        }

        // 将信息列表存储在请求属性中
        HttpSession session = request.getSession();
        session.setAttribute("infoList", infoList);
        request.setAttribute("infoList", infoList);
        request.getRequestDispatcher("reviewInfo.jsp").forward(request, response);


    }

    // 从文件中读取信息并解析为 BasicInfo 对象的方法
    private BasicInfo readInfoFromFile(File file) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .create();

        BasicInfo info = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            info = gson.fromJson(sb.toString(), BasicInfo.class);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return info;
    }

    private static class DateDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }
}
