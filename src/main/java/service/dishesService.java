package service;

import pojo.dishes;

import java.util.List;

public interface dishesService {
//    根据商家ID遍历菜品
    public List<dishes> list(Integer s_id);
    public void add(dishes Dishes);
public List<dishes> search(String name,Integer s_id);
public void update(dishes dishes);
public  void  del(Integer id);
}
