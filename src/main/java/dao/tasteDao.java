package dao;

import pojo.dishes;
import pojo.taste;

import java.util.List;

public interface tasteDao {
    public Integer add(taste taste);
    public List<taste> list(Integer d_id);
    public Integer update(taste taste);
    public Integer del(Integer id);

}

