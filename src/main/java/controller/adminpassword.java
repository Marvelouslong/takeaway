package controller;

import pojo.administrators;

import service.impl.administratorsServiceImpl;

import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminpassword")
public class adminpassword extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        administratorsServiceImpl adminService = new administratorsServiceImpl();
        String password= req.getParameter("password");
        administrators admin = new administrators();
        admin.setPassword(password);
        Object admins = req.getSession().getAttribute(constant.ADMIN_SESSION);
        long account_number = ((pojo.administrators) admins).getAccount_number();
        System.out.println(account_number);
//        administrators Admin= new administrators();
        admin.setAccount_number(account_number);
        Boolean flag = adminService.modifypassword(admin);
        //判断是否修改成功来决定跳转到哪个页面
        if (flag) {
            resp.sendRedirect("loginadmin.jsp");
        } else {
            req.getRequestDispatcher("adminpassword.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
