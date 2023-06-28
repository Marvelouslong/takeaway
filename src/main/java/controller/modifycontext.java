package controller;

import pojo.rider;
import javax.servlet.annotation.MultipartConfig;

import service.impl.modifyriderServiceImpl;
import service.modifyriderService;
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

@WebServlet("/modifycontext")
@MultipartConfig
public class modifycontext extends HttpServlet {
    private modifyriderService modifyservice = new modifyriderServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object rider = req.getSession().getAttribute(constant.RIDER_SESSION);
        Integer id = ((pojo.rider) rider).getId();
        pojo.rider Rider = new rider();
        Rider.setId(id);
        //        Integer id = Integer.valueOf(req.getParameter("d_id"));
        long phone = Long.parseLong(req.getParameter("phone"));
        long bank_card= Long.parseLong(req.getParameter("bank_card"));
        String work_city = req.getParameter("work_city");
        String password =req.getParameter("password");
        try {
            this.modifyservice.modifycontext(new rider(id,phone,bank_card,work_city,password));
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
