package service.impl;

import dao.BaseDao;
import dao.administratorsDao;
import dao.impl.administratorsDaoImpl;
import pojo.administrators;
import service.administratorsService;

import java.sql.Connection;

public class administratorsServiceImpl implements administratorsService {
    private administratorsDaoImpl adminDao;
    public administratorsServiceImpl(){adminDao= new administratorsDaoImpl();}
    //管理员登录
    public administrators login(long account_number, String password) {
        Connection connection=null;
        administrators admin=new administrators();
        try {
            connection= BaseDao.getConnection();
            admin = adminDao.getLoginAdmin(connection, account_number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,  null);
        }
        return admin;
    }
}
