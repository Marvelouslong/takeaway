package service.impl;

import dao.impl.riderregisterDaoImpl;
import dao.riderregisterDao;
import pojo.rider;
import service.riderregisterService;

import java.util.List;

public class riderregisterServiceImpl implements riderregisterService {
    private riderregisterDao riderregisterdao=new riderregisterDaoImpl();
    @Override
    public List<rider> list(int ad_id){return this.riderregisterdao.list(ad_id);}

    @Override
    public List<rider> list(Integer ad_id) {
        return null;
    }

    public List<rider> list1(){
        return this.riderregisterdao.list1();
    }
    public List<rider> search(String key, String value) {
        if (value.equals("")) return this.riderregisterdao.list1();
        return this.riderregisterdao.search(key, value);
    }
    public void save(rider Rider){
        Integer save=this.riderregisterdao.save(Rider);
        if(save!=1) throw new RuntimeException("添加失败");
    }
    public void update(rider Rider) {
        Integer update = this.riderregisterdao.update(Rider);
        if(update!=1) throw new RuntimeException("修改失败");
    }

    @Override
    public void del(Integer id) {
        Integer update = this.riderregisterdao.del(id);
        if(update!=1) throw new RuntimeException("更新社团信息失败");

    }

    public void del(int id){
        Integer del = this.riderregisterdao.del(id);
        if(del!=1) throw new RuntimeException("删除失败");
    }

    @Override
    public void update1(rider Rider) {
        Integer update1 = this.riderregisterdao.update1(Rider);

    }

}
