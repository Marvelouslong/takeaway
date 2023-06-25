package dao;

import pojo.order;

import java.sql.Connection;
import java.util.List;

public interface newsorderDao {
    //显示骑手拥有的订单
    public List<order> getorderlist(Connection connection, long phone)throws Exception;
}
