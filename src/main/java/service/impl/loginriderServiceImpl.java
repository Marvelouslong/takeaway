package service.impl;

import dao.BaseDao;
import dao.impl.loginriderDaoImpl;
import dao.loginriderDao;
import pojo.rider;
import service.loginriderService;

import java.sql.Connection;

public class loginriderServiceImpl implements loginriderService {
    private loginriderDao loginriderdao;
    public loginriderServiceImpl(){loginriderdao= new loginriderDaoImpl();}
    //商家登录
    public rider loginrider(long telephone, String password) {
        Connection connection=null;
        rider Rider =new rider();
        try {
            connection= BaseDao.getConnection();
            Rider =loginriderdao.getLoginRider(connection, telephone);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,  null);
        }
        return Rider;
    }
}
