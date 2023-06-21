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
import javax.servlet.http.Part;
import java.io.File;
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
                req.setAttribute("dishes_list", this.dishesservice.list(s_id));
                req.getRequestDispatcher("/jsp/store/store_main.jsp").forward(req, resp);
                break;
            case "dishes_add" :
                String name = req.getParameter("name");
                String describe = req.getParameter("describe");
                String status = req.getParameter("status");
                double price = Double.parseDouble(req.getParameter("price"));
                String category = req.getParameter("category");
                store = req.getSession().getAttribute(constant.STORE_SESSION);
                s_id = ((pojo.store) store).getId();
//                String name1 = req.getParameter("name1");
//                String name2 = req.getParameter("name2");
//                String name3 = req.getParameter("name3");
//                String name4 = req.getParameter("name4");
//                String name5 = req.getParameter("name5");
                Part filePart = req.getPart("picture");
                byte[] picture = filePart.getInputStream().readAllBytes();
                this.dishesservice.add(new dishes(name,describe,status,price,category,picture,s_id));
                resp.sendRedirect("DISHES?method=list_dishes");
                break;
        }
    }
}
