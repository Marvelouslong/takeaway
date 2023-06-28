package dao;

import pojo.dishes;
import pojo.order;
import pojo.order_dishes;

import java.util.List;

public interface orderDao {
    public List<order> list(Integer s_id);
    public List<order> list1(Integer id);
    public List<order> list3(Integer id);
    public List<order> list4(Integer id);
    public List<order_dishes> list2(Integer id);
    public Integer update(order order);
}
