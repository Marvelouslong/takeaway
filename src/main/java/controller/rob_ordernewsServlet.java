package controller;

import pojo.order;
import pojo.rider;
import service.impl.rob_ordernewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import service.rob_ordernewsService;
import util.constant;

@WebServlet("/rob_ordernews")
public class rob_ordernewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Object rider = req.getSession().getAttribute(constant.RIDER_SESSION);
        long phone = ((pojo.rider) rider).getPhone();
        pojo.rider Rider = new rider();
        Rider.setPhone(phone);
        //        Integer id = Integer.valueOf(req.getParameter("d_id"));
//        long phone = Long.parseLong(req.getParameter("phone"));
        rob_ordernewsServiceImpl roborderService = new rob_ordernewsServiceImpl();
        List<order> rob_orderlist=null;
        rob_orderlist = roborderService.getorderlist(phone);
        req.setAttribute("rob_orderlist",rob_orderlist);
        req.getRequestDispatcher("rob_ordernews.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
