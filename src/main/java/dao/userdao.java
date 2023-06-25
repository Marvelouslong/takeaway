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
}
