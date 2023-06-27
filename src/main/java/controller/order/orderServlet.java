package controller.order;

import pojo.taste;
import service.impl.orderServiceImpl;
import service.impl.tasteServiceImpl;
import service.orderService;
import service.tasteService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ORDER")
public class orderServlet extends HttpServlet {
    private orderService orderservice = new orderServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method) {
            case "list":
                Object store = req.getSession().getAttribute(constant.STORE_SESSION);
                Integer s_id = ((pojo.store) store).getId();
                req.setAttribute("order_list", this.orderservice.list(s_id));
                req.getRequestDispatcher("/jsp/store/store_order.jsp").forward(req, resp);
                break;
            case "list3":
                store = req.getSession().getAttribute(constant.STORE_SESSION);
                 s_id = ((pojo.store) store).getId();
                req.setAttribute("order_list", this.orderservice.list3(s_id));
                req.getRequestDispatcher("/jsp/store/store_order.jsp").forward(req, resp);
                break;
            case "list4":
                 store = req.getSession().getAttribute(constant.STORE_SESSION);
                 s_id = ((pojo.store) store).getId();
                req.setAttribute("order_list", this.orderservice.list4(s_id));
                req.getRequestDispatcher("/jsp/store/store_order.jsp").forward(req, resp);
                break;
            case "update":
                break;
            case "list2":
                 Integer id= Integer.valueOf(req.getParameter("id"));
                req.setAttribute("order", this.orderservice.list1(id));
                req.setAttribute("dish",this.orderservice.list2(id));
                req.getRequestDispatcher("/jsp/store/order.jsp").forward(req, resp);
                break;
        }
    }
}
