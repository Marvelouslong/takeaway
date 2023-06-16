package service;

import pojo.administrators;
import pojo.store;

public interface storeService {
    //商家登录
    public store login(long con_telephone, String password);
}
