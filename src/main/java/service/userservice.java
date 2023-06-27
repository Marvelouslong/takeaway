package service;

import pojo.*;

import java.util.List;

public interface userservice {
    public List<store> getstorelist(String query, int currentPageNo, int pageSize);
    public int getstoreCount(String query);
    public List<talk> gettalklist(int currentPageNo, int pageSize);
    public byte[] img(int id);
    public byte[] img1(int id);
    public int saveUserImage(int id,byte[]imgdata,String name, Long phone1,String sex, String signature, String password);
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
    public List<dishes> dishlist(int id);
    public List<taste> tastelist(int id);
    public List<receiver> getreceiverlist(int id);
    public int changeostatus(int id);
    public int change_receiver(int id,String name,Long phone,String address);
    public int addre(int count,String name,long phone,String address,int id);
    public int getreceiverCount();
    public int upshop(int id,int id1,String taste);
    public int getstoreid(int id);
    public int delevaluate(int id);
    public List<shopcar_dishes> carlist(int id,int id1);
    public int delshop(int sid,int id);
    public List<shopcar_dishes> shopcarlist(int id1);
}
