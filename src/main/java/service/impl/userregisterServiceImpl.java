package service.impl;

import dao.impl.riderregisterDaoImpl;
import dao.impl.userregisterDaoImpl;
import dao.riderregisterDao;
import dao.userregisterDao;
import org.junit.platform.commons.logging.LoggerFactory;
import pojo.rider;
import pojo.user;
import service.userregisterService;

import java.util.logging.Logger;

public class userregisterServiceImpl implements userregisterService {
    private userregisterDao userregisterdao= new userregisterDaoImpl();
    @Override
    public void add(user User) {
        Integer add = this.userregisterdao.add(User);
        if (add != 1) throw new RuntimeException("添加失败");

    }
}
