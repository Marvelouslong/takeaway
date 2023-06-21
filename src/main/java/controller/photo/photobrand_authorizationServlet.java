package controller.photo;

import service.impl.photoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/picturebrand_authorization")
public class photobrand_authorizationServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private photoServiceImpl fbpi = new photoServiceImpl(); //调用service

        public photobrand_authorizationServlet() {
            super();
            // TODO Auto-generated constructor stub
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            this.doPost(request, response);
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            String id = request.getParameter("id"); //前端传来的图片id
            byte[] picturebrand_authorization = fbpi.picturebrand_authorization(Integer.parseInt(id)); //获得bookPicture
            response.setContentType("image/jpg");  //设置图片格式
            OutputStream out = response.getOutputStream(); //打开输出流
            out.write(picturebrand_authorization);  //输出图片
            out.flush();	//输出
            out.close();  //关闭输出
        }

}