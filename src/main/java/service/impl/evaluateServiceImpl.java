package service.impl;

import dao.evaluateDao;
import dao.impl.evaluateDaoImpl;
import pojo.dishes;
import pojo.evaluate;
import service.evaluateService;

import java.util.List;

public class evaluateServiceImpl implements evaluateService {
    private evaluateDao evaluateDao = new evaluateDaoImpl();

    public List<evaluate> list(Integer s_id){
        return this.evaluateDao.list(s_id);
    }
    public void update(evaluate evaluate) {
        Integer add = this.evaluateDao.update(evaluate);
        if(add !=1)throw new RuntimeException("更新失败");}
    public void del(Integer id){
        Integer del = this.evaluateDao.del(id);
        if(del!=1) throw  new RuntimeException("删除失败");
    }
}
