package service.impl;

import dao.impl.riderregisterDaoImpl;
import dao.riderregisterDao;
import pojo.dishes;
import pojo.rider;
import service.riderregisterService;

import java.util.List;

public class riderregisterServiceImpl implements riderregisterService {
    private riderregisterDao riderregisterdao = new riderregisterDaoImpl();
    @Override
    public void add(rider Rider) {
        Integer add = this.riderregisterdao.add(Rider);
        if (add != 1) throw new RuntimeException("添加失败");

    }
}
