package dao;

import pojo.dishes;
import pojo.order;

import java.util.List;

public interface orderDao {
    public List<order> list(Integer s_id);
}
