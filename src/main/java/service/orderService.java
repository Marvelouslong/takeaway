package service;

import pojo.dishes;
import pojo.order;

import java.util.List;

public interface orderService {
    public List<order> list(Integer s_id);
}
