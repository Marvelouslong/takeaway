package service.impl;

import dao.BaseDao;
import dao.impl.userdaoimpl;
import dao.userdao;
import pojo.*;
import service.userservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class userserviceimpl implements userservice {

    private userdao Userdao;

    public userserviceimpl() {
        Userdao = new userdaoimpl();
    }
    @Override
    public List<store> getstorelist(String query, int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<store> storelist = null;
        try {
            connection = BaseDao.getConnection();
            storelist = Userdao.getstorelist(connection, query,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return storelist;
    }

    @Override
    public int getstoreCount(String query) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.getstoreCount(connection, query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<talk> gettalklist(int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<talk> talklist = null;
        try {
            connection = BaseDao.getConnection();
            talklist = Userdao.gettalklist(connection,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return talklist;
    }

    @Override
    public byte[] img(int id) {
        Connection connection = null;
        byte[] picture=null;
        try {
            connection = BaseDao.getConnection();
            picture=Userdao.img(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return picture;
    }

    @Override
    public byte[] img1(int id) {
        Connection connection = null;
        byte[] picture=null;
        try {
            connection = BaseDao.getConnection();
            picture=Userdao.img1(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return picture;
    }

    @Override
    public int saveUserImage(int id, byte[] imgdata,String name, Long phone1,String sex, String signature, String password) {
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            count=Userdao.saveUserImage(connection,id,imgdata,name,phone1,sex,signature,password);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<order> getorderlist(int id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<order> orderlist = null;
        try {
            connection = BaseDao.getConnection();
            orderlist = Userdao.getorderlist(connection,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return orderlist;
    }

    @Override
    public List<dishes> showdish(int id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<dishes> dishlist = null;
        try {
            connection = BaseDao.getConnection();
            dishlist = Userdao.showdish(connection,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return dishlist;
    }
    @Override
    public byte[] img2(int id) {
        Connection connection = null;
        byte[] picture=null;
        try {
            connection = BaseDao.getConnection();
            picture=Userdao.img2(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return picture;
    }

    @Override
    public int addevaluate(int id,byte[]imgdata,String evaluate) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            count = Userdao.addevaluate(connection,id,imgdata,evaluate);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public byte[] img3(int id) {
        Connection connection = null;
        byte[] picture=null;
        try {
            connection = BaseDao.getConnection();
            picture=Userdao.img3(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return picture;
    }

    @Override
    public List<evaluate> showevaluate(int id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<evaluate> evaluatelist = null;
        try {
            connection = BaseDao.getConnection();
            evaluatelist = Userdao.showevaluate(connection,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return evaluatelist;
    }

    @Override
    public byte[] img4(int id) {
        Connection connection = null;
        byte[] picture=null;
        try {
            connection = BaseDao.getConnection();
            picture=Userdao.img4(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return picture;
    }

    @Override
    public byte[] img5(int id) {
        Connection connection = null;
        byte[] picture=null;
        try {
            connection = BaseDao.getConnection();
            picture=Userdao.img5(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return picture;
    }

    @Override
    public int gettalkCount() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.gettalkCount(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int savetalk(int id,byte[] bytes,String context) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            count = Userdao.savetalk(connection,id,bytes,context);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<store> storelist(int id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<store> storelist = null;
        try {
            connection = BaseDao.getConnection();
            storelist = Userdao.storelist(connection,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return storelist;
    }
    public List<dishes> dishlist(int id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<dishes> dishlist = null;
        try {
            connection = BaseDao.getConnection();
            dishlist = Userdao.dishlist(connection,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return dishlist;
    }
    public List<taste> tastelist(int id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<taste> tastelist = null;
        try {
            connection = BaseDao.getConnection();
            tastelist = Userdao.tastelist(connection,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return tastelist;
    }

    @Override
    public List<receiver> getreceiverlist(int id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<receiver> receiverlist = null;
        try {
            connection = BaseDao.getConnection();
            receiverlist = Userdao.getreceiverlist(connection,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return receiverlist;
    }

    @Override
    public int changeostatus(int id) {
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            count = Userdao.changeostatus(connection,id);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }
    public int change_receiver(int id,String name,Long phone,String address) {
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.change_receiver(connection,id,name,phone,address);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int addre(String name,long phone,String address,int id) {
        Connection connection = null;
        int count1=0;
        try {
            connection = BaseDao.getConnection();
            count1 = Userdao.addre(connection,name,phone,address,id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count1;
    }

    @Override
    public int upshop(int id, int id1,String taste) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.upshop(connection,id,id1,taste);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int getstoreid(int id) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.getstoreid(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int delevaluate(int id) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.delevaluate(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<shopcar_dishes> carlist(int id, int id1) {
        Connection connection = null;
        List<shopcar_dishes> carlist=null;
        try {
            connection = BaseDao.getConnection();
            carlist = Userdao.carlist(connection,id,id1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return carlist;
    }

    @Override
    public int delshop(int sid, int id) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.delshop(connection,sid,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<shopcar_dishes> shopcarlist(int id1) {
        Connection connection = null;
        List<shopcar_dishes> carlist=null;
        try {
            connection = BaseDao.getConnection();
            carlist = Userdao.shopcarlist(connection,id1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return carlist;
    }

    @Override
    public int order(String payway, String notes, double money, int rid, int id, int sid) {
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            count = Userdao.order(connection,payway,notes,money,rid,id,sid);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }
}
