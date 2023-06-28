package service;

import pojo.dishes;
import pojo.evaluate;
import pojo.order;

import java.util.List;

public interface evaluateService {
    public List<evaluate> list(Integer s_id);
    public void update(evaluate evaluate);
    public  void  del(Integer id);
    public List<evaluate> search(Integer id);
}
