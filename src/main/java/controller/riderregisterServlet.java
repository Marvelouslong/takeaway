package controller;

import com.mysql.cj.jdbc.Blob;
import pojo.rider;
import service.impl.riderregisterServiceImpl;
import service.riderregisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/riderregister")
public class riderregisterServlet extends HttpServlet {
    private riderregisterService riderregisterservice=new riderregisterServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        switch (method){
            case "ridertable":
                Integer ad_id=req.getIntHeader("ad_id");
                req.setAttribute("list", this.riderregisterservice.list(ad_id));
                req.getRequestDispatcher("ridertable.jsp").forward(req, resp);
                break;
            case "list":
                req.setAttribute("list1",this.riderregisterservice.list1());
                req.getRequestDispatcher("rideroperate.jsp").forward(req,resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list1",this.riderregisterservice.search(key,value));
                req.getRequestDispatcher("rideroperate.jsp").forward(req,resp);
                break;
            case "save":
                Integer id=req.getIntHeader("id");
                long phone=req.getDateHeader("phone");
                String name=req.getParameter("name");
                String id_card=req.getParameter("id_card");
                Blob driver_license= (Blob) req.getPart("driver_license");
                long bank_card=req.getDateHeader("bank_card");
                String work_city=req.getParameter("work_city");
                String status=req.getParameter("status");
                String password=req.getParameter("password");
                this.riderregisterservice.save(new rider(id,phone,name,id_card,driver_license,bank_card,work_city,status,password));
                resp.sendRedirect("Rider?method=list");
                break;
            case "update":
                ad_id = req.getIntHeader("ad_id");
                if(!Objects.equals(ad_id, "0")){
                    id=req.getIntHeader("id");
                    phone=req.getDateHeader("phone");
                    name=req.getParameter("name");
                    id_card=req.getParameter("id_card");
                    driver_license= (Blob) req.getPart("driver_license");
                    bank_card=req.getDateHeader("bank_card");
                    work_city=req.getParameter("work_city");
                    status=req.getParameter("status");
                    password=req.getParameter("password");
                    ad_id=req.getIntHeader("ad_id");
//                      status= req.getParameter("status");
                    status = "full";
                    this.riderregisterservice.update(new rider(id,phone,name,id_card,driver_license,bank_card,work_city,status,password,ad_id));}
                else{
                    id=req.getIntHeader("id");
                    phone=req.getDateHeader("phone");
                    name=req.getParameter("name");
                    id_card=req.getParameter("id_card");
                    driver_license= (Blob) req.getPart("driver_license");
                    bank_card=req.getDateHeader("bank_card");
                    work_city=req.getParameter("work_city");
                    password=req.getParameter("password");
                    status = "审核中";
                    this.riderregisterservice.update(new rider(id,phone,name,id_card,driver_license,bank_card,work_city,status,password));
                }
                resp.sendRedirect("Rider?method=list");
                break;
            case "del":
                id= req.getIntHeader("id");
                this.riderregisterservice.del(id);
                resp.sendRedirect("classroom?method=list");
                break;
            case"update1":
                id = req.getIntHeader("id");
                ad_id = req.getIntHeader("ad_id");
                this.riderregisterservice.update1(new rider(id,ad_id));
                resp.sendRedirect("Rider?method=list");
        }

    }
}
