package service;

import pojo.dishes;

import java.util.List;

public interface dishesService {
//    根据商家ID遍历菜品
    public List<dishes> list(Integer s_id);
}
