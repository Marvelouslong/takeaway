package controller.store;
import pojo.store;
import service.impl.storeServiceImpl;
import service.storeService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/STORE1")

public class StoreServlet extends HttpServlet {
    private storeService storeService = new storeServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method) {
            case "list":
                req.getRequestDispatcher("/jsp/store/store.jsp").forward(req, resp);
                break;

            case "update":
                Object store = req.getSession().getAttribute(constant.STORE_SESSION);
                Integer s_id = ((pojo.store) store).getId();
                String address = req.getParameter("address");
                long con_telephone = Long.parseLong(req.getParameter("con_telephone"));
                String password = req.getParameter("password");
                String main_category=req.getParameter("main_category");
                String auxiliary_category=req.getParameter("auxiliary_category");
                this.storeService.update(new store(s_id,address,con_telephone,password,main_category,auxiliary_category));
                req.getRequestDispatcher("/jsp/store/store.jsp").forward(req, resp);
                break;
            case "update1":
                req.getRequestDispatcher("loginstore.jsp").forward(req, resp);
                break;

        }
    }
}
