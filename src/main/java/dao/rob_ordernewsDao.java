package dao;

import pojo.order;
import pojo.rider;

import java.sql.Connection;
import java.util.List;

public interface rob_ordernewsDao {
    //显示没有骑手的订单
    public List<order> getorderlist(Connection connection)throws Exception;
    //抢全部的单
    public  int modify(Connection connection, rider Rider) throws Exception;
    //抢一个订单
    public  int rob(Connection connection, rider Rider,order Order) throws Exception;
}
