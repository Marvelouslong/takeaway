package service.impl;

import dao.dishesDao;
import dao.impl.dishesDaoImpl;
import dao.impl.tasteDaoImpl;
import dao.tasteDao;
import pojo.dishes;
import pojo.taste;
import service.tasteService;

import java.util.List;

public class tasteServiceImpl implements tasteService {
    private tasteDao tastedao = new tasteDaoImpl();
    @Override
    public void add(taste taste) {
            Integer add = this.tastedao.add(taste);
            if(add !=1)throw new RuntimeException("添加失败");
        }

    public List<taste> list(Integer d_id){
        return this.tastedao.list(d_id);
    }
    public void update(taste taste) {
        Integer add = this.tastedao.update(taste);
        if(add !=1)throw new RuntimeException("更新失败");}
    public void del(Integer id){
        Integer del = this.tastedao.del(id);
        if(del!=1) throw  new RuntimeException("删除失败");
    }

    }

