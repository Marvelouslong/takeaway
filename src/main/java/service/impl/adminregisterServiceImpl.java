package service.impl;

import dao.adminregisterDao;
import dao.impl.adminregisterDaoImpl;
import pojo.administrators;
import pojo.user;
import service.adminregisterService;

public class adminregisterServiceImpl implements adminregisterService {
    private adminregisterDao adminregisterdao= new adminregisterDaoImpl();
    @Override
    public void add(administrators Administrators) {
        Integer add = this.adminregisterdao.add(Administrators);
        if (add != 1) throw new RuntimeException("添加失败");

    }
}
