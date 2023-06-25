package service.impl;


import dao.impl.storeregisterDaoImpl;
import dao.riderregisterDao;
import dao.storeregisterDao;
import pojo.dishes;
import pojo.rider;
import pojo.store;
import service.storeregisterService;

import java.util.List;

public class storeregisterServiceImpl implements storeregisterService {
    private storeregisterDao storeregisterdao = new storeregisterDaoImpl();


    @Override
    public void add(store Store) {
        Integer add = this.storeregisterdao.add(Store);
        if (add != 1) throw new RuntimeException("添加失败");

    }
}
