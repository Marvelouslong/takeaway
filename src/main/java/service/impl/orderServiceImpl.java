package service.impl;

import dao.dishesDao;
import dao.impl.dishesDaoImpl;
import dao.impl.orderDaoImpl;
import dao.orderDao;
import pojo.dishes;
import pojo.order;
import service.orderService;

import java.util.List;

public class orderServiceImpl implements orderService {
    private orderDao orderdao = new orderDaoImpl();
    public List<order> list(Integer s_id){
        return this.orderdao.list(s_id);
    }
}
