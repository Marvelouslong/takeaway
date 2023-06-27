package service;

import pojo.administrators;
import pojo.store;

import java.util.List;

public interface storeService {
    //商家登录
    public store login(long con_telephone, String password);
    //商家信息
    public List<store> getstoreList();
    //修改状态
    public Boolean modify(store shop,administrators admin) throws Exception;
}
