package service;

import pojo.administrators;

public interface administratorsService {
    //管理员登录
    public administrators login(long account_number, String password);
}
