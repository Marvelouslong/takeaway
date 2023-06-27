package service.impl;

import dao.BaseDao;
import dao.impl.rob_ordernewsDaoImpl;
import dao.rob_ordernewsDao;
import pojo.order;
import pojo.rider;
import service.rob_ordernewsService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class rob_ordernewsServiceImpl implements rob_ordernewsService {
    private rob_ordernewsDao robdao;
    public rob_ordernewsServiceImpl() {
        robdao = new rob_ordernewsDaoImpl();
    }
    public List<order> getorderlist(long phone) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<order> orderlist = null;
        try {
            connection = BaseDao.getConnection();
            orderlist = robdao.getorderlist(connection,phone);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return orderlist;
    }
    public Boolean rob(rider Rider,order Order){
        Boolean flag=false;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务
            int updateNum = robdao.rob(connection, Rider,Order);//执行修改sql
            connection.commit();//提交事务
            if(updateNum>0){
                flag=true;
                System.out.println("修改用户成功");
            }else{
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
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
}
