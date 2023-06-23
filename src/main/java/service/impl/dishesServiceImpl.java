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

}
