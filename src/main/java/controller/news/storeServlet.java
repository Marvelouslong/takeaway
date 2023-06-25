package controller.news;

import pojo.store;
import service.impl.storeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/store")
public class storeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //显示用户
        storeServiceImpl storeService = new storeServiceImpl();
        List<store> storeList=null;
        storeList = storeService.getstoreList();
        req.setAttribute("storeList",storeList);
        req.getRequestDispatcher("/news/storenews.jsp").forward(req,resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}