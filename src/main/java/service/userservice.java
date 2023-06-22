package service;

import pojo.*;

import java.util.List;

public interface userservice {
    public List<store> getstorelist(String query, int currentPageNo, int pageSize);
    public int getstoreCount(String query);
    public List<talk> gettalklist();
    public byte[] img(int id);
    public byte[] img1(int id);
    public int saveUserImage(int id,byte[]imgdata);
    public List<order> getorderlist(int id);
    public List<dishes> showdish(int id);
    public byte[] img2(int id);
}
