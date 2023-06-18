package service.impl;

import dao.BaseDao;
import dao.impl.userdaoimpl;
import dao.userdao;
import pojo.store;
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
}
