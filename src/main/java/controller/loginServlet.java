package controller;

import pojo.administrators;
import service.administratorsService;
import service.impl.administratorsServiceImpl;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet  extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("LoginServlet--start~~");
        long account_number = Long.parseLong(req.getParameter("account_number"));
        String password = req.getParameter("password");
        administratorsService adminService = new administratorsServiceImpl();
        administrators admin = adminService.login(account_number, password);
        if (null != admin) {
            if (!(admin.getAccount_number()==account_number && admin.getPassword().equals(password)))
                admin = null;
        }
        if (admin != null) {
            req.getSession().setAttribute(constant.ADMIN_SESSION, admin);
            resp.sendRedirect("frame.jsp");
        } else {
            req.setAttribute("error", "账号或者密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}