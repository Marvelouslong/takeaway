package controller;

import com.mysql.cj.jdbc.Blob;
import pojo.dishes;
import pojo.rider;
import service.impl.riderregisterServiceImpl;
import service.riderregisterService;
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
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Objects;

@WebServlet("/riderregisterServlet")
public class riderregisterServlet extends HttpServlet {
    private riderregisterService riderregisterservice=new riderregisterServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        long phone = req.getDateHeader("phone");
        String id_card = req.getParameter("id_card");
        long bank_card = req.getDateHeader("bank_card");
        String work_city = req.getParameter("work_city");
        String password = req.getParameter("password");
        String status = ("正在审核");
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
        byte[] driver_license = bytes;
        this.riderregisterservice.add(new rider(name,phone,id_card,bank_card,work_city,password,status,driver_license));
        req.getRequestDispatcher("/loginrider.jsp").forward(req, resp);
    }


}
