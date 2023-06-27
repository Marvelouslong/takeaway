package service.impl;

import dao.BaseDao;
import dao.impl.storeDaoImpl;
import dao.storeDao;
import pojo.dishes;
import pojo.store;
import service.storeService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class storeServiceImpl implements storeService {
    private storeDao shopDao;
    public storeServiceImpl(){shopDao= new storeDaoImpl();}
    //商家登录
    public store login(long con_telephone, String password) {
        Connection connection=null;
        store shop =new store();
        try {
            connection= BaseDao.getConnection();
            shop =shopDao.getLoginStore(connection, con_telephone);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,  null);
        }
        return shop;
    }
    //显示商家信息
    public List<store> getstoreList(){
        Connection connection = null;
        List<store> storeList = null;
        try {
            connection = BaseDao.getConnection();
            storeList = shopDao.getstoreList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return storeList;
    }
    public Boolean modify(store shop) {
        Boolean flag=false;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务
            int updateNum = shopDao.modify(connection, shop);//执行修改sql
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
    public void update(store store) {
        Integer add = this.shopDao.update(store);
        if(add !=1)throw new RuntimeException("更新失败");}
    public void update1(store store) {
        Integer add = this.shopDao.update1(store);
        if(add !=1)throw new RuntimeException("更新失败");}
}
