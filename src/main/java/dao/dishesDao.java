package dao;

import pojo.dishes;

import java.util.List;

public interface dishesDao {
    public List<dishes> list(Integer s_id);
    public Integer add(dishes Dishes);
}
