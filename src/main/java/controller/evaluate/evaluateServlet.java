package controller.evaluate;

import pojo.dishes;
import pojo.evaluate;
import pojo.taste;
import service.evaluateService;
import service.impl.evaluateServiceImpl;
import service.impl.tasteServiceImpl;
import service.tasteService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/EVA")

public class evaluateServlet extends HttpServlet {
    private evaluateService evaluateservice = new evaluateServiceImpl();

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
                req.setAttribute("list", this.evaluateservice.list(s_id));
                req.getRequestDispatcher("/jsp/store/store_ele.jsp").forward(req, resp);
                break;
            case "update":
                int id = Integer.parseInt(req.getParameter("id"));
                String shop_evaluate = req.getParameter("shop_evaluate");
                this.evaluateservice.update(new evaluate(id,shop_evaluate));
                req.getRequestDispatcher("/EVA?method=list").forward(req, resp);
                break;
            case "del":
                id = Integer.parseInt(req.getParameter("id"));
                this.evaluateservice.del(id);
                req.getRequestDispatcher("/EVA?method=list").forward(req, resp);
            case "search":
                id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("list",this.evaluateservice.search(id));
                req.getRequestDispatcher("/EVA?method=list").forward(req, resp);
                break;
        }
    }
}
