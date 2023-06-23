package service.impl;

import dao.dishesDao;
import dao.impl.dishesDaoImpl;
import pojo.dishes;
import service.dishesService;

import java.util.List;

public class dishesServiceImpl  implements dishesService {
    private dishesDao dishesdao = new dishesDaoImpl();
    public List<dishes> list(Integer s_id){
        return this.dishesdao.list(s_id);
    }

    @Override
    public void add(dishes Dishes) {
        Integer add = this.dishesdao.add(Dishes);
        if(add !=1)throw new RuntimeException("添加失败");
    }
    public List<dishes> search(String name,Integer s_id){
        return this.dishesdao.search(name,s_id);
    }

    public void update(dishes dishes) {
        Integer add = this.dishesdao.update(dishes);
        if(add !=1)throw new RuntimeException("更新失败");}
    public void del(Integer id){
        Integer del = this.dishesdao.del(id);
        if(del!=1) throw  new RuntimeException("删除失败");
    }
}
