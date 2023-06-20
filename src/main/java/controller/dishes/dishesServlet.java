package controller.dishes;

import pojo.dishes;
import pojo.store;
import service.dishesService;
import service.impl.dishesServiceImpl;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DISHES")
public class dishesServlet extends HttpServlet {
    private dishesService dishesservice = new dishesServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method) {
            case "list_dishes":
                Object store = req.getSession().getAttribute(constant.STORE_SESSION);
                Integer s_id = ((pojo.store) store).getId();
                req.setAttribute("list", this.dishesservice.list(s_id));
                req.getRequestDispatcher("store_main.jsp").forward(req, resp);
                break;
        }
    }
}
