package service;

import pojo.administrators;
import pojo.store;

import java.util.List;

public interface administratorsService {
    //管理员登录
    public administrators login(long account_number, String password);
    public Boolean modifypassword(administrators admin) throws Exception;
}
