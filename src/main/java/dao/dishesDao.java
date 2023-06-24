package dao;

import pojo.dishes;

import java.util.List;

public interface dishesDao {
    public List<dishes> list(Integer s_id);
    public Integer add(dishes Dishes);
    public List<dishes> search(String name,Integer s_id);
    public Integer update(dishes dishes);
    public Integer del(Integer id);
}
