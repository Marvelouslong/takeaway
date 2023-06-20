package service;

import pojo.user;

public interface userloginService {
    //用户登录
    public user userlogin(long phone, String password);
}
