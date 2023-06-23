package service.impl;

import dao.BaseDao;
import dao.impl.modifyriderDaoImpl;
import dao.modifyriderDao;
import pojo.rider;
import service.modifyriderService;

import java.sql.Connection;
import java.sql.SQLException;

public class modifyriderServiceImpl implements modifyriderService {
    private modifyriderDao modifyriderdao;
    public modifyriderServiceImpl(){modifyriderdao= new modifyriderDaoImpl();}
    public Boolean modifyrider(rider Rider) {
        Boolean flag=false;
        Connection connection=null;
        try {
            connection= BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务
            int updateNum = modifyriderdao.modifyrider(connection, Rider);//执行修改sql
            connection.commit();//提交事务
            if(updateNum>0){
                flag=true;
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //若抛出异常，则说明修改失败需要回滚
            System.out.println("no1");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
}
