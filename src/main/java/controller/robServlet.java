package controller;

import pojo.order;
import pojo.rider;
import service.impl.rob_ordernewsServiceImpl;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rob")
public class robServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Object rider = req.getSession().getAttribute(constant.RIDER_SESSION);
        Integer rid = ((pojo.rider) rider).getId();
        rob_ordernewsServiceImpl roborderService = new rob_ordernewsServiceImpl();
        //需要拿到前端传递进来的参数
//        long phone = Long.parseLong(req.getParameter("phone"));
        int id= Integer.parseInt(req.getParameter("id"));
        //创建一个对象接收这些参数
        rider Rider = new rider();
        Rider.setId(rid);
        order Order=new order();
        Order.setId(id);
        //调用service层
        Boolean flag = roborderService.rob(Rider,Order);

        //判断是否修改成功来决定跳转到哪个页面
        if (flag) {
            req.getRequestDispatcher("rob_back").forward(req,resp);
        } else {
            req.getRequestDispatcher("rob.jsp").forward(req, resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
