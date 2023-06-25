package controller;

import pojo.dishes;
import pojo.user;
import service.impl.userregisterServiceImpl;
import service.tasteService;
import service.userregisterService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
@WebServlet("/userregister")
public class userregisterServlet extends HttpServlet {
    private userregisterService userregisterservice = new userregisterServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        long phone= Long.parseLong(req.getParameter("phone"));
        String password=req.getParameter("password");
        String signature=req.getParameter("signature");
        String sex=req.getParameter("sex");
//                获取图片
        Part filePart = req.getPart("image"); // 通过 name 获取上传的文件
        InputStream inputStream = filePart.getInputStream(); // 获取文件输入流
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = inputStream.read(buffer))) {
            output.write(buffer, 0, n);
        }
        byte[] bytes = output.toByteArray();
        output.flush();
        output.close();
        inputStream.close();
        byte[] picture = bytes;
        this.userregisterservice.add(new user(name,phone,password,signature,sex,picture));
        req.getRequestDispatcher("/loginuser.jsp").forward(req, resp);
    }
}

