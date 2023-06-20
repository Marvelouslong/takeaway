package controller;

import pojo.store;
import service.impl.storeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/modifystore")
public class modifystatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得页面的修改用户信息
        storeServiceImpl shopService = new storeServiceImpl();
        //需要拿到前端传递进来的参数
//        String id=req.getParameter("id");
//        int id = Integer.parseInt(req.getParameter("id"));
//        String address= req.getParameter("address");
//        long con_telephone = Long.parseLong(req.getParameter("con_telephone"));
//        String shop_name = req.getParameter("shop_name");
//        String con_name =req.getParameter("con_name");
        String legal_id_card=req.getParameter("legal_id_card");
        String status=req.getParameter("status");
        //创建一个对象接收这些参数
        store shop = new store();
//        shop.setId(Integer.parseInt(id));
//        shop.setAddress(address);
//        shop.setCon_telephone(con_telephone);
//        shop.setShop_name(shop_name);
//        shop.setCon_name(con_name);
//        shop.setPassword(password);
//        shop.setBrand_authorization(brand_authorization);
//        shop.setBank_card(bank_card);
//        shop.setLicense(license);
//        shop.setCertificate_of_business(certificate_of_business);
        shop.setLegal_id_card(legal_id_card);
        shop.setStatus(status);
//        shop.setShop_picture(shop_picture);
//        shop.setMain_category(main_category);
//        shop.setAuxiliary_category(auxiliary_category);
        //调用service层
        Boolean flag = shopService.modify(shop);

        //判断是否修改成功来决定跳转到哪个页面
        if (flag) {
            resp.sendRedirect("store");
        }
        else {
            req.getRequestDispatcher("modifystore.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
