package dao;

import pojo.order_dishes;
import pojo.store;
import pojo.talk;

import java.sql.Connection;
import java.util.List;

public interface userdao {
    public int getstoreCount(Connection connection, String query) throws Exception;

    public List<store> getstorelist(Connection connection, String query, int currentPageNo, int pageSize)throws Exception;
    public List<talk> gettalklist(Connection connection)throws Exception;
    public byte[] img(Connection connection,int id);
    public byte[] img1(Connection connection,int id);
    public int saveUserImage(Connection connection,int id,byte[]imgdata);
    public List<order_dishes> getorderlist(Connection connection,int id)throws Exception;
}
