package controller;

import pojo.user;
import service.impl.userloginServiceImpl;
import service.userloginService;
import util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class userloginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("LoginServlet--start~~");
        long phone = Long.parseLong(req.getParameter("phone"));
        String password = req.getParameter("password");
        userloginService userloginservice = new userloginServiceImpl();
        user visitor =userloginservice.userlogin(phone, password);
        if (null != visitor) {
            if (visitor.getPhone()==phone &&visitor.getPassword().equals(password))
            { req.getSession().setAttribute(Constants.USER_SESSION,visitor);
                resp.sendRedirect("Userservlet?method=query&query=null&pageIndex=1");}
            else{req.setAttribute("error", "密码错误");
                req.getRequestDispatcher("loginuser.jsp").forward(req, resp);}
        }
        else {
            req.setAttribute("error", "账号错误");
            req.getRequestDispatcher("loginuser.jsp").forward(req, resp);
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        doGet(req, resp);
    }
}
