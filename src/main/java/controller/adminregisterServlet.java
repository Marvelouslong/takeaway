package controller;

import pojo.administrators;
import pojo.user;
import service.adminregisterService;
import service.impl.adminregisterServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
@WebServlet("/adminregister")
public class adminregisterServlet extends HttpServlet {
    private adminregisterService adminregisterservice = new adminregisterServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        long account_number= Long.parseLong(req.getParameter("account_number"));
        String password=req.getParameter("password");
        this.adminregisterservice.add(new administrators(name,account_number,password));
        req.getRequestDispatcher("/login/loginadmin.jsp").forward(req, resp);
    }
}

