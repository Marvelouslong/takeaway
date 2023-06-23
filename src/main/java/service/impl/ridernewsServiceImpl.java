package service.impl;

import dao.BaseDao;
import dao.impl.ridernewsDaoImpl;
import pojo.rider;
import service.ridernewsService;

import java.sql.Connection;
import java.util.List;


public class ridernewsServiceImpl  implements ridernewsService {
    private ridernewsDaoImpl riderDao;
    public ridernewsServiceImpl(){ riderDao= new ridernewsDaoImpl();}
    //显示骑手信息
    public List<rider> getriderList(){
        Connection connection = null;
        List<rider> riderList = null;
        try {
            connection = BaseDao.getConnection();
            riderList = riderDao.getriderList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return riderList;
    }
}
