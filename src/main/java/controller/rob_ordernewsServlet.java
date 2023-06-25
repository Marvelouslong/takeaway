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

@WebServlet("/rob_ordernews")
public class rob_ordernewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        rob_ordernewsServiceImpl roborderService = new rob_ordernewsServiceImpl();
        List<order> rob_orderlist=null;
        rob_orderlist = roborderService.getorderlist();
        req.setAttribute("rob_orderlist",rob_orderlist);
        req.getRequestDispatcher("rob_ordernews.jsp").forward(req,resp);
//        //增加骑手订单
//        //需要拿到前端传递进来的参数
//        long phone= Long.parseLong(req.getParameter("phone"));
//        //创建一个对象接收这些参数
//        rider Rider= new rider();
//        Rider.setPhone(phone);
//
//        //调用service层
//        Boolean flag = roborderService.modify(Rider);
//
//        //判断是否修改成功来决定跳转到哪个页面
//        if (flag) {
//            resp.sendRedirect("loginrider.jsp");
//        }
//        else {
//            req.getRequestDispatcher("o.jsp").forward(req, resp);
//        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
