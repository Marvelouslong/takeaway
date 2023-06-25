package controller.login;

import pojo.order;
import pojo.rider;
import service.impl.loginriderServiceImpl;
import service.impl.newsorderServiceImpl;
import service.loginriderService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginrider")
public class loginriderServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        long phone = Long.parseLong(req.getParameter("phone"));
        String password = req.getParameter("password");
        loginriderService loginriderservice = new loginriderServiceImpl();
        rider Rider = loginriderservice.loginrider(phone, password);
        if (null != Rider) {
            if (Rider.getPhone() == phone && Rider.getPassword().equals(password) && Rider.getStatus().equals("通过")) {
                req.getSession().setAttribute(constant.RIDER_SESSION, Rider);
                System.out.println(phone);
                newsorderServiceImpl orderService = new newsorderServiceImpl();
                List<order> orderList=null;
                orderList = orderService.getorderlist(phone);
                req.setAttribute("orderList",orderList);
                req.getRequestDispatcher("/news/ordernews.jsp").forward(req,resp);
            }
            else{
                if (!(Rider.getPassword().equals(password))) {
                    req.setAttribute("error", "密码错误");
                    req.getRequestDispatcher("loginrider.jsp").forward(req, resp);
                }
                if (Rider.getStatus().equals("正在审核")) {
                    req.setAttribute("error", "正在审核中，请耐心等待");
                    req.getRequestDispatcher("loginrider.jsp").forward(req, resp);
                }
                if (Rider.getStatus().equals("未通过")) {
                    req.setAttribute("error", "审核未通过");
                    req.getRequestDispatcher("loginrider.jsp").forward(req, resp);
                }
            }
        }
        else{req.setAttribute("error", "账号错误");
            req.getRequestDispatcher("loginrider.jsp").forward(req, resp);}
    }
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
