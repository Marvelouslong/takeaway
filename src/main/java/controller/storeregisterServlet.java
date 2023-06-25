package controller;

import pojo.rider;
import pojo.store;
import service.impl.riderregisterServiceImpl;
import service.impl.storeregisterServiceImpl;
import service.riderregisterService;
import service.storeregisterService;
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

@WebServlet("/storeregisterServlet")
public class storeregisterServlet extends HttpServlet {
    private storeregisterService storeregisterservice=new storeregisterServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        req.setCharacterEncoding("UTF-8");
        String address = req.getParameter("address");
        long con_telephone = req.getDateHeader("con_telephone");
        String shop_name=req.getParameter("shop_name");
        String con_name=req.getParameter("con_name");
        String password = req.getParameter("password");
        long bank_card=req.getDateHeader("bank_card");
        String legal_id_card=req.getParameter("legal_id_card");
        String main_category=req.getParameter("main_category");
        String auxiliary_category=req.getParameter("auxiliary_category");
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
        byte[] brand_authorization = bytes;
        byte[] license=bytes;
        byte[] certificate_of_business=bytes;
        byte[] shop_picture=bytes;
        this.storeregisterservice.add(new store(address,con_telephone,shop_name,con_name,password,bank_card,legal_id_card,main_category,auxiliary_category,status,brand_authorization,license,certificate_of_business,shop_picture));
        req.getRequestDispatcher("/loginstore.jsp").forward(req, resp);

        }
    }


