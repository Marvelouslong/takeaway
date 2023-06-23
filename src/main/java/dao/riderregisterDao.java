package dao;

import pojo.rider;

import java.util.List;

public interface riderregisterDao {
    public List<rider> list(int ad_id);

    List<rider> list(String ad_id);

    public List<rider> list1();
    public List<rider> search(String key, String value);
    public Integer save(rider Rider);
    public Integer update(rider Rider);
    public Integer del(int id);
    public Integer update1(rider Rider);
}