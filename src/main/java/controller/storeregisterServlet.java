package controller;

import pojo.rider;
import pojo.store;
import service.impl.riderregisterServiceImpl;
import service.impl.storeregisterServiceImpl;
import service.riderregisterService;
import service.storeregisterService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/storeregister")
@MultipartConfig
public class storeregisterServlet extends HttpServlet {
    private storeregisterService storeregisterservice=new storeregisterServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        req.setCharacterEncoding("UTF-8");
        String address = req.getParameter("address");
        long con_telephone = Long.parseLong(req.getParameter("con_telephone"));
        String shop_name=req.getParameter("shop_name");
        String con_name=req.getParameter("con_name");
        String password = req.getParameter("password");
        long bank_card= Long.parseLong(req.getParameter("bank_card"));
        String legal_id_card=req.getParameter("legal_id_card");
        String main_category=req.getParameter("main_category");
        String auxiliary_category=req.getParameter("auxiliary_category");
        String status = ("正在审核");
//                获取图片
        Part filePart1 = req.getPart("brand_authorization"); // 通过 name 获取上传的文件
        InputStream inputStream1 = filePart1.getInputStream(); // 获取文件输入流
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = inputStream1.read(buffer))) {
            output.write(buffer, 0, n);
        }
        byte[] bytes = output.toByteArray();
        output.flush();
        output.close();
        inputStream1.close();
        byte[] brand_authorization = bytes;
        Part filePart2 = req.getPart("license");
        InputStream inputStream2 = filePart2.getInputStream();
        output = new ByteArrayOutputStream();
        buffer = new byte[4096];
        n = 0;
        while (-1 != (n = inputStream2.read(buffer))) {
            output.write(buffer, 0, n);
        }
        bytes = output.toByteArray();
        output.flush();
        output.close();
        inputStream1.close();
        byte[] license=bytes;
        Part filePart3 = req.getPart("license");
        InputStream inputStream3 = filePart3.getInputStream();
        output = new ByteArrayOutputStream();
        buffer = new byte[4096];
        n = 0;
        while (-1 != (n = inputStream3.read(buffer))) {
            output.write(buffer, 0, n);
        }
        byte[] certificate_of_business=bytes;
        Part filePart4 = req.getPart("license");
        InputStream inputStream4 = filePart4.getInputStream();
        output = new ByteArrayOutputStream();
        buffer = new byte[4096];
        n = 0;
        while (-1 != (n = inputStream4.read(buffer))) {
            output.write(buffer, 0, n);
        }
        byte[] shop_picture=bytes;
        this.storeregisterservice.add(new store(address,con_telephone,shop_name,con_name,password,bank_card,legal_id_card,main_category,auxiliary_category,status,brand_authorization,license,certificate_of_business,shop_picture));
        req.getRequestDispatcher("/loginstore.jsp").forward(req, resp);
        }
    }


