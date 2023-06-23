package service.impl;

import dao.BaseDao;
import dao.impl.userdaoimpl;
import dao.userdao;
import pojo.*;
import service.userservice;

import java.sql.Connection;
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
    public List<talk> gettalklist() {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<talk> talklist = null;
        try {
            connection = BaseDao.getConnection();
            talklist = Userdao.gettalklist(connection);
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
    public int saveUserImage(int id, byte[] imgdata) {
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            count=Userdao.saveUserImage(connection,id,imgdata);
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
    public int addevaluate(int id,byte[]imgdata,String evaluate,int count1) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.addevaluate(connection,id,imgdata,evaluate,count1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
    public int getevaluateCount() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.getevaluateCount(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
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
    public int savetalk(int id,byte[] bytes,String context,int count1) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            count = Userdao.savetalk(connection,id,bytes,context,count1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }
}
