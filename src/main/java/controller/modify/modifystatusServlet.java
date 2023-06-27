package controller.modify;

import pojo.administrators;
import pojo.store;
import service.impl.storeServiceImpl;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/modifystore")
public class modifystatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得页面的修改用户信息
        storeServiceImpl shopService = new storeServiceImpl();
//        //需要拿到前端传递进来的参数
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
        store shop = new store();
        shop.setId(id);
        shop.setStatus(status);
        Object admin = req.getSession().getAttribute(constant.ADMIN_SESSION);
        long account_number = ((pojo.administrators) admin).getAccount_number();
        System.out.println(account_number);
        administrators Admin= new administrators();
        Admin.setAccount_number(account_number);
        //调用service层
        Boolean flag = shopService.modify(shop,Admin);

        //判断是否修改成功来决定跳转到哪个页面
        if (flag) {
            resp.sendRedirect("store");
        } else {
            req.getRequestDispatcher("/news/storenews.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
