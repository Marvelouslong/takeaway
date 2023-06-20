package service.impl;

import dao.BaseDao;
import dao.impl.userloginDaoImpl;
import dao.userloginDao;
import pojo.user;
import service.userloginService;

import java.sql.Connection;

public class userloginServiceImpl implements userloginService {
    private userloginDaoImpl userloginDao;
    public userloginServiceImpl(){
        userloginDao=new userloginDaoImpl();
    }
    //用户登录
    public user userlogin(long phone, String password) {
        Connection connection=null;
        user visitor=new user();
        try {
            connection= BaseDao.getConnection();
            visitor = userloginDao.getLoginUser(connection, phone);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,  null);
        }
        return visitor;
    }
}
