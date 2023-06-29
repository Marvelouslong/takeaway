package controller;

import pojo.rider;
import service.impl.modifyriderServiceImpl;
import service.modifyriderService;
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

@WebServlet("/modifydriver")
@MultipartConfig
public class modifydriver extends HttpServlet {
    private modifyriderService modifyservice = new modifyriderServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object rider = req.getSession().getAttribute(constant.RIDER_SESSION);
        Integer id = ((pojo.rider) rider).getId();
        pojo.rider Rider = new rider();
        Rider.setId(id);
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
        try {
            this.modifyservice.modifydriver(new rider(id,picture));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("loginrider.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
