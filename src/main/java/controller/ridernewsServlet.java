package controller;

import pojo.rider;
import service.impl.ridernewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ridernews")
public class ridernewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //显示用户
        ridernewsServiceImpl ridernewsservice = new ridernewsServiceImpl();
        List<rider> ridernewsList=null;
        ridernewsList = ridernewsservice.getriderList();
        req.setAttribute("ridernewsList",ridernewsList);
        req.getRequestDispatcher("ridernews.jsp").forward(req,resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
