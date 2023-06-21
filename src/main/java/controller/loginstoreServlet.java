package controller;

import pojo.store;
import service.impl.storeServiceImpl;
import service.storeService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginstoreServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        long con_telephone = Long.parseLong(req.getParameter("con_telephone"));
        String password = req.getParameter("password");
        storeService shopService = new storeServiceImpl();
        store shop = shopService.login(con_telephone, password);
        if (null != shop) {
            if (shop.getCon_telephone() == con_telephone && shop.getPassword().equals(password) && shop.getStatus().equals("通过")) {
                req.getSession().setAttribute(constant.STORE_SESSION, shop);
                resp.sendRedirect("DISHES?method=list_dishes");
            }
            else{
                if (!(shop.getPassword().equals(password))) {
                    req.setAttribute("error", "密码错误");
                    req.getRequestDispatcher("loginstore.jsp").forward(req, resp);
                }
                if (shop.getStatus().equals("正在审核")) {
                    req.setAttribute("error", "正在审核中，请耐心等待");
                    req.getRequestDispatcher("loginstore.jsp").forward(req, resp);
                }
                if (shop.getStatus().equals("未通过")) {
                    req.setAttribute("error", "审核未通过");
                    req.getRequestDispatcher("loginstore.jsp").forward(req, resp);
                }
            }
        }
        else{req.setAttribute("error", "账号错误");
                req.getRequestDispatcher("loginstore.jsp").forward(req, resp);}
    }
        public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }
    }