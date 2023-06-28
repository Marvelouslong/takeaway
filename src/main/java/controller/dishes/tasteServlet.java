package controller.dishes;
import pojo.taste;
import service.impl.tasteServiceImpl;
import service.tasteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/TASTE")

public class tasteServlet extends HttpServlet {
    private tasteService tasteservice = new tasteServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method) {
            case "list":
                Integer d_id = Integer.valueOf(req.getParameter("d_id"));
                req.setAttribute("list", this.tasteservice.list(d_id));
                req.setAttribute("d_id", d_id);
                req.getRequestDispatcher("/jsp/store/taste_main.jsp").forward(req, resp);
                break;
            case "add":
                d_id = Integer.valueOf(req.getParameter("d_id"));
                String name = req.getParameter("name");
                this.tasteservice.add(new taste(name, d_id));
                req.getRequestDispatcher("/TASTE?method=list").forward(req, resp);
                break;
//            case "update":
//                 name = req.getParameter("name");
//                Integer id = Integer.valueOf(req.getParameter("id"));
//                this.tasteservice.update(new taste(id,name));
//                resp.sendRedirect("/TASTE?method=list");
//                break;
            case "del":
                Integer id = Integer.valueOf(req.getParameter("id"));
                this.tasteservice.del(id);
                req.getRequestDispatcher("/TASTE?method=list").forward(req, resp);
                break;
        }
    }
}
