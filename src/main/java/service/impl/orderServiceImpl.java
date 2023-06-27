package service.impl;

import dao.impl.orderDaoImpl;
import dao.orderDao;
import pojo.order;
import pojo.order_dishes;
import service.orderService;

import java.util.List;

public class orderServiceImpl implements orderService {
    private orderDao orderdao = new orderDaoImpl();
    public List<order> list(Integer s_id){
        return this.orderdao.list(s_id);
    }
    public List<order> list3(Integer s_id){
        return this.orderdao.list3(s_id);
    }
    public List<order> list4(Integer s_id){
        return this.orderdao.list4(s_id);
    }
    public List<order> list1(Integer id){
        return this.orderdao.list1(id);
    }
    public List<order_dishes> list2(Integer id){
        return this.orderdao.list2(id);
    }
}
