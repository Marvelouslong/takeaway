package service.impl;

import dao.BaseDao;
import dao.impl.newsorderDaoImpl;
import dao.newsorderDao;
import pojo.order;
import service.newsorderService;

import java.sql.Connection;
import java.util.List;

public class newsorderServiceImpl implements newsorderService {
    private newsorderDao newsdao;
    public newsorderServiceImpl() {
        newsdao = new newsorderDaoImpl();
    }
    public List<order> getorderlist(long phone) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<order> orderlist = null;
        try {
            connection = BaseDao.getConnection();
            orderlist = newsdao.getorderlist(connection,phone);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return orderlist;
    }
}
