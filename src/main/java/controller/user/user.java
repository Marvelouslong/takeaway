package controller.user;

import org.apache.commons.fileupload.FileUploadException;
import pojo.store;
import pojo.talk;
import service.impl.userserviceimpl;
import service.userservice;
import util.Constants;
import util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
@WebServlet("/Userservlet")
@MultipartConfig
public class user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("talkshow")) {
            this.talkshow(req, resp);
        } else if (method != null && method.equals("query")) {
            String query = req.getParameter("query");
            if (query.equals("null")) {
                query = "";
            }
            String pageIndex = req.getParameter("pageIndex");
            this.query(req, resp, query, pageIndex);
        } else if (method != null && method.equals("myinformation")) {
            this.myinformation(req, resp);
        } else if (method != null && method.equals("img")) {
            String id = req.getParameter("id");
            this.img(req, resp, id);
        } else if (method != null && method.equals("img1")) {
            String id = req.getParameter("id");
            this.img1(req, resp, id);
        }
//        else if (method != null && method.equals("change-user-img")) {
//            try {
//                this.change_user_img(req, resp);
//            } catch (FileUploadException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        else if (method != null && method.equals("view")) {
//            this.getUserById(req, resp, "userview.jsp");
//        } else if (method != null && method.equals("modify")) {
//            this.getUserById(req, resp, "usermodify.jsp");
//        } else if (method != null && method.equals("modifyexe")) {
//            this.modify(req, resp);
//        } else if (method != null && method.equals("pwdmodify")) {
//            this.getPwdByUserId(req, resp);
//        } else if (method != null && method.equals("savepwd")) {
//            this.updatePwd(req, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("change-user-img")) {
            try {
                this.change_user_img(req, resp);
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void query(HttpServletRequest req, HttpServletResponse resp, String query, String pageIndex) throws IOException, ServletException {
        userservice userservice = new userserviceimpl();

        //设置页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        int currentPageNo = 1;

        if (query == null) {
            query = "";
        }
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.parseInt(pageIndex);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "error");
            }
        }

        //获取用户总数量
        int totalCount = userservice.getstoreCount(query);
        //总页数支持
        PageSupport pages = new PageSupport();
        //设置当前页码
        pages.setCurrentPageNo(currentPageNo);
        //设置页总大小
        pages.setPageSize(pageSize);
        //设置页总数量
        pages.setTotalCount(totalCount);

        //控制首页和尾页
        int totalPageCount = pages.getTotalPageCount();

        if (currentPageNo < 1) {  //显示第一页的东西
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {//当前页面大于最后一页，让它为最后一页就行
            currentPageNo = totalPageCount;
        }

        List<store> storelist = null;
        storelist = userservice.getstorelist(query, currentPageNo, pageSize);
        req.setAttribute("storelist", storelist);
        req.setAttribute("query", query);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.getRequestDispatcher("/jsp/user/homepage.jsp").forward(req, resp);
    }

    private void talkshow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userservice userservice = new userserviceimpl();
        List<talk> talklist = null;
        talklist = userservice.gettalklist();
        req.setAttribute("talklist", talklist);
        req.getRequestDispatcher("/jsp/user/talk.jsp").forward(req, resp);
    }

    private void myinformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/user/myinformation.jsp").forward(req, resp);
    }

    private void img(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picturebrand_authorization = userservice.img(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picturebrand_authorization);  //输出图片
        out.flush();    //输出
        out.close();  //关闭输出
    }

    private void img1(HttpServletRequest req, HttpServletResponse resp, String id) throws ServletException, IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picturebrand_authorization = userservice.img1(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picturebrand_authorization);  //输出图片
        out.flush();    //输出
        out.close();  //关闭输出
    }

    private void change_user_img(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, FileUploadException {
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

        // 将文件保存到数据库中
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        int id = ((pojo.user) attribute).getId();
        int count = 0;
        // 插入图片数据到数据库中
        userservice userService = new userserviceimpl();
        count = userService.saveUserImage(id, bytes);
        if(count!=0)
        req.setAttribute("message", "上传成功");
        req.getRequestDispatcher("/jsp/user/myinformation.jsp").forward(req, resp);
    }
}
