package service;

import pojo.store;
import pojo.talk;

import java.util.List;

public interface userservice {
    public List<store> getstorelist(String query, int currentPageNo, int pageSize);
    public int getstoreCount(String query);
    public List<talk> gettalklist();
    public byte[] img(int id,String type,String table);
}
