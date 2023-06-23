package controller;

import pojo.rider;
import service.impl.modifyriderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyrider")
public class modifyriderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得页面的修改用户信息
       modifyriderServiceImpl riderService = new modifyriderServiceImpl();
       //需要拿到前端传递进来的参数
        Integer id= Integer.valueOf(req.getParameter("id"));
        String type = req.getParameter("type");
        String status=" ";
        switch (type) {
            case "pass":
                status = "通过";
                break;
            case "abc":
                status = "正在审核";
                break;
            case "nopass":
                status= "未通过";
                break;
            default:
                System.out.println("buxing");
        }
        System.out.println(status);
        //创建一个对象接收这些参数
        rider Rider = new rider();
        Rider.setId(id);
        Rider.setStatus(status);
        //调用service层
        Boolean flag = riderService.modifyrider(Rider);
        //判断是否修改成功来决定跳转到哪个页面
        if (flag) {
            resp.sendRedirect("ridernews");
        } else {
            req.getRequestDispatcher("ridernews.jsp").forward(req, resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
