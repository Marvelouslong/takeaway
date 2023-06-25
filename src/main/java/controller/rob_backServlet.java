package controller;

import pojo.order;
import pojo.rider;
import service.impl.newsorderServiceImpl;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/rob_back")
public class rob_backServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object rider = req.getSession().getAttribute(constant.RIDER_SESSION);
        long phone = ((pojo.rider) rider).getPhone();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        Integer rid = ((pojo.rider) rider).getId();
//        long phone = Long.parseLong(req.getParameter("phone"));
        pojo.rider Rider = new rider();
        Rider.setPhone(phone);
        newsorderServiceImpl orderService = new newsorderServiceImpl();
        List<order> orderList=null;
        orderList = orderService.getorderlist(phone);
        req.setAttribute("orderList",orderList);
        req.getRequestDispatcher("/news/ordernews.jsp").forward(req,resp);
    }
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
