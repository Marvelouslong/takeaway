package service.impl;

import dao.BaseDao;
import dao.administratorsDao;
import dao.impl.administratorsDaoImpl;
import pojo.administrators;
import pojo.store;
import service.administratorsService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
    public Boolean modifypassword(administrators admin) {
        Boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务
            int updateNum = adminDao.modifypassword(connection, admin);//执行修改sql
            connection.commit();//提交事务
            if (updateNum > 0) {
                flag = true;
                System.out.println("修改用户成功");
            } else {
                System.out.println("修改用户失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //若抛出异常，则说明修改失败需要回滚
            System.out.println("修改失败，回滚事务");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
