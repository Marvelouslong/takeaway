package service;

import pojo.store;
import pojo.talk;

import java.util.List;

public interface userservice {
    public List<store> getstorelist(String query, int currentPageNo, int pageSize);
    public int getstoreCount(String query);
    public List<talk> gettalklist();
    public byte[] img(int id);
    public byte[] img1(int id);
    public int saveUserImage(int id,byte[]imgdata);
}
