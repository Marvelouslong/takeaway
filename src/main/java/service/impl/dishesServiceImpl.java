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

}
