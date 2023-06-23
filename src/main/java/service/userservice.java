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
    public int addevaluate(int id,byte[]imgdata,String evaluate,int count1);
    public byte[] img3(int id);
    public List<evaluate> showevaluate(int id);
    public int getevaluateCount();
    public byte[] img4(int id);
    public byte[] img5(int id);
    public int gettalkCount();
    public int savetalk(int id,byte[] bytes,String context,int count1);
    public List<store> storelist(int id);
}
