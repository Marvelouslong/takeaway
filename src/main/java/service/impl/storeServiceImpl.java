package service.impl;

import dao.BaseDao;
import dao.impl.administratorsDaoImpl;
import dao.impl.storeDaoImpl;
import pojo.administrators;
import pojo.store;
import service.storeService;

import java.sql.Connection;

public class storeServiceImpl implements storeService {
    private storeDaoImpl shopDao;
    public storeServiceImpl(){shopDao= new storeDaoImpl();}
    //管理员登录
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
}
