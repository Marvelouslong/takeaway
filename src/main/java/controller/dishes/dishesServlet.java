package controller.dishes;


import pojo.dishes;
import service.dishesService;
import service.impl.dishesServiceImpl;
import service.impl.tasteServiceImpl;
import service.tasteService;
import util.constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@WebServlet("/DISHES")
@MultipartConfig

public class dishesServlet extends HttpServlet {
    private dishesService dishesservice = new dishesServiceImpl();
    private tasteService tasteservice = new tasteServiceImpl();

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
            case "dishes_add":
                String name = req.getParameter("name");
                String describe = req.getParameter("describe");
                String status = req.getParameter("status");
                double price = Double.parseDouble(req.getParameter("price"));
                String category = req.getParameter("category");
                store = req.getSession().getAttribute(constant.STORE_SESSION);
                s_id = ((pojo.store) store).getId();
                Part filePart = req.getPart("image"); // 通过 name 获取上传的文件
                InputStream inputStream = filePart.getInputStream(); // 获取文件输入流
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int n = 0;
                while (-1 != (n = inputStream.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                byte[] bytes = output.toByteArray();
                output.flush();
                output.close();
                inputStream.close();
                byte[] picture = bytes;
                this.dishesservice.add(new dishes(name,describe,status,price,category,picture,s_id));
                resp.sendRedirect("DISHES?method=list_dishes");
                break;
            case "dish_search":
                break;
        }
    }
}
