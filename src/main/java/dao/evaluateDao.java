package dao;

import pojo.dishes;
import pojo.evaluate;
import pojo.order;

import java.util.List;

public interface evaluateDao {
    public List<evaluate> list(Integer s_id);
    public Integer update(evaluate evaluate);
    public Integer del(Integer id);
}
