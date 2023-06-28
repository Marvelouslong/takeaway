package dao;

import pojo.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface userdao {
    public int getstoreCount(Connection connection, String query) throws Exception;
    public List<store> getstorelist(Connection connection, String query, int currentPageNo, int pageSize)throws Exception;
    public List<talk> gettalklist(Connection connection,int currentPageNo, int pageSize)throws Exception;
    public byte[] img(Connection connection,int id) throws Exception;
    public byte[] img1(Connection connection,int id) throws Exception;
    public int saveUserImage(Connection connection,int id,byte[]imgdata,String name, Long phone1,String sex, String signature, String password) throws SQLException;
    public List<order> getorderlist(Connection connection, int id)throws Exception;
    public List<dishes> showdish(Connection connection, int id)throws Exception;
    public byte[] img2(Connection connection,int id) throws Exception;
    public int addevaluate(Connection connection,int id,byte[]imgdata,String evaluate,int count1) throws SQLException;
    public byte[] img3(Connection connection,int id) throws Exception;
    public List<evaluate> showevaluate(Connection connection, int id)throws Exception;
    public int getevaluateCount(Connection connection) throws Exception;
    public byte[] img4(Connection connection,int id) throws Exception;
    public byte[] img5(Connection connection,int id) throws Exception;
    public int gettalkCount(Connection connection) throws Exception;
    public int savetalk(Connection connection,int id,byte[] bytes,String context,int count1) throws SQLException;
    public List<store> storelist(Connection connection, int id)throws Exception;
    public List<dishes> dishlist(Connection connection, int id)throws Exception;
    public List<taste> tastelist(Connection connection, int id)throws Exception;
    public List<receiver> getreceiverlist(Connection connection, int id)throws Exception;
    public int changeostatus(Connection connection,int id) throws Exception;
    public int change_receiver(Connection connection,int id,String name,Long phone,String address) throws Exception;
    public int getreceiverCount(Connection connection) throws Exception;
    public int addre(Connection connection,int count,String name,Long phone,String address,int id) throws Exception;
    public int upshop(Connection connection,int id,int id1,String taste) throws Exception;
    public int getstoreid(Connection connection,int id) throws Exception;
    public int delevaluate(Connection connection,int id) throws Exception;
    public List<shopcar_dishes> carlist(Connection connection, int id,int id1)throws Exception;
    public int delshop(Connection connection,int sid,int id) throws Exception;
    public List<shopcar_dishes> shopcarlist(Connection connection, int id1)throws Exception;
    public int order(Connection connection,String payway, String notes, double money, int rid, int id, int sid) throws Exception;
}
