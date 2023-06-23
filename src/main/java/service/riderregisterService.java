package service;

import pojo.rider;

import java.util.List;

public interface riderregisterService {
    List<rider> list(int ad_id);

    public List<rider> list(Integer ad_id);
    public List<rider> list1();
    public List<rider> search(String key, String value);
    public void save(rider Rider);
    public void update(rider Rider);

    void del(Integer id);

    public void del(int id);
    public void  update1(rider Rider);
}

