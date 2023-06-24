package controller.user;

import org.apache.commons.fileupload.FileUploadException;
import pojo.*;
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
            String pageIndex = req.getParameter("pageIndex");
            this.talkshow(req, resp,pageIndex);
        } else if (method != null && method.equals("query")) {
            String query = req.getParameter("query");
            if (query.equals("null")) {
                query = "";
            }
            String pageIndex = req.getParameter("pageIndex");
            System.out.println(query);
            this.query(req, resp, query, pageIndex);
        } else if (method != null && method.equals("myinformation")) {
            this.myinformation(req, resp);
        } else if (method != null && method.equals("img")) {
            String id = req.getParameter("id");
            this.img(req, resp, id);
        } else if (method != null && method.equals("img1")) {
            String id = req.getParameter("id");
            this.img1(req, resp, id);
        }else if (method != null && method.equals("showdishes")) {
            String id = req.getParameter("id");
            int id1= Integer.parseInt(id);
            this.showdishes(req, resp,id1);
        }else if (method != null && method.equals("img2")) {
            String id = req.getParameter("id");
            this.img2(req, resp, id);
        }else if (method != null && method.equals("img3")) {
            String id = req.getParameter("id");
            this.img3(req, resp, id);
        }else if (method != null && method.equals("showevaluate")) {
            String id = req.getParameter("id");
            int id1= Integer.parseInt(id);
            this.showevaluate(req, resp,id1);
        }else if (method != null && method.equals("img4")) {
            String id = req.getParameter("id");
            this.img4(req, resp, id);
        }else if (method != null && method.equals("img5")) {
            String id = req.getParameter("id");
            this.img5(req, resp, id);
        }
        else if (method != null && method.equals("storelist")) {
            String id = req.getParameter("id");
            this.storelist(req, resp, id);
        }
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
        }else if (method != null && method.equals("addevaluate")) {
            String id = req.getParameter("id");
            int id1= Integer.parseInt(id);
            this.addevaluate(req, resp,id1);
        }else if (method != null && method.equals("upload-talk")) {
            this.upload_talk(req, resp);
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

    private void talkshow(HttpServletRequest req, HttpServletResponse resp, String pageIndex) throws ServletException, IOException {
        userservice userservice = new userserviceimpl();
        //设置页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        int currentPageNo = 1;

        if (pageIndex != null) {
            try {
                currentPageNo = Integer.parseInt(pageIndex);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "error");
            }
        }

        //获取用户总数量
        int totalCount = userservice.gettalkCount();
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


        List<talk> talklist = null;
        talklist = userservice.gettalklist();
        req.setAttribute("talklist", talklist);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.getRequestDispatcher("/jsp/user/talk.jsp").forward(req, resp);
    }

    private void myinformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        int id = ((pojo.user) attribute).getId();
        userservice userservice = new userserviceimpl();
        List<order> orderlist = null;
        orderlist = userservice.getorderlist(id);
        req.setAttribute("orderlist", orderlist);
        req.getRequestDispatcher("/jsp/user/myinformation.jsp").forward(req, resp);
    }

    private void img(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picture = userservice.img(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picture);  //输出图片
        out.flush();    //输出
        out.close();  //关闭输出
    }

    private void img1(HttpServletRequest req, HttpServletResponse resp, String id) throws ServletException, IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picture = userservice.img1(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picture);  //输出图片
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

        // 将文件保存到数据库中
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        int id = ((pojo.user) attribute).getId();
        int count = 0;
        // 插入图片数据到数据库中
        userservice userService = new userserviceimpl();
        count = userService.saveUserImage(id, bytes);
        if(count!=0) {
            req.getRequestDispatcher("/jsp/user/myinformation.jsp").forward(req, resp);
        }
    }
    private void showdishes(HttpServletRequest req, HttpServletResponse resp,int id) throws ServletException, IOException {
        userservice userservice = new userserviceimpl();
        List<dishes> dishlist = null;
        dishlist = userservice.showdish(id);
        req.setAttribute("dishlist", dishlist);
        req.getRequestDispatcher("/jsp/user/myinformation.jsp").forward(req, resp);
    }
    private void img2(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picture = userservice.img2(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picture);  //输出图片
        out.flush();    //输出
        out.close();  //关闭输出
    }
    private void showevaluate(HttpServletRequest req, HttpServletResponse resp,int id) throws ServletException, IOException {
        userservice userservice = new userserviceimpl();
        List<evaluate> evaluatelist = null;
        evaluatelist = userservice.showevaluate(id);
        req.setAttribute("evaluatelist", evaluatelist);
        req.setAttribute("o_id",id);
        req.getRequestDispatcher("/jsp/user/evaluate.jsp").forward(req, resp);
    }
    private void addevaluate(HttpServletRequest req, HttpServletResponse resp, int id) throws IOException, ServletException {
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

        userservice userservice = new userserviceimpl();
        List<evaluate> evaluatelist = null;
        int count=0;
        int count1=0;
        String evaluate=req.getParameter("evaluate");
        count=userservice.getevaluateCount();
        count+=1;
        count1 = userservice.addevaluate(id,bytes,evaluate,count);
        if(count1!=0) {
            this.showevaluate(req,resp,id);
        }
    }
    private void img3(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picture = userservice.img3(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picture);  //输出图片
        out.flush();    //输出
        out.close();  //关闭输出
    }
    private void img4(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picture = userservice.img4(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picture);  //输出图片
        out.flush();    //输出
        out.close();  //关闭输出
    }
    private void img5(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        byte[] picture = userservice.img5(id1);
        resp.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = resp.getOutputStream(); //打开输出流
        out.write(picture);  //输出图片
        out.flush();    //输出
        out.close();  //关闭输出
    }
    private void upload_talk(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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

        // 将文件保存到数据库中
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        int id = ((pojo.user) attribute).getId();
        String context=req.getParameter("talkcontext");
        int count = 0;
        // 插入图片数据到数据库中
        userservice userService = new userserviceimpl();
        int count1=0;
        count1=userService.gettalkCount();
        count1+=1;
        count = userService.savetalk(id, bytes,context,count1);
        String pageIndex="1";
        if(count!=0) {
            this.talkshow(req,resp,pageIndex);
        }
    }
    private void storelist(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException, ServletException {
        int id1 = Integer.parseInt(id);
        userservice userservice = new userserviceimpl();
        List<store> storelist = null;
        storelist = userservice.storelist(id1);
        List<dishes> dishlist = null;
        dishlist = userservice.dishlist(id1);
        req.setAttribute("storelist", storelist);
        req.setAttribute("dishlist", dishlist);
        req.getRequestDispatcher("/jsp/user/store.jsp").forward(req, resp);
    }
}
