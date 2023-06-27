package dao;

import pojo.administrators;
import pojo.store;

import java.sql.Connection;
import java.util.List;

public interface storeDao {
    //得到登录的商家
    public store getLoginStore(Connection connection,long con_telephone ) throws  Exception;
    //查看商家信息
    public List<store> getstoreList(Connection connection) throws  Exception;
    //修改状态
    public int modify(Connection connection,store shop,administrators admin)throws Exception;
}
