package dao.impl;

import dao.ridernewsDao;
import pojo.rider;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ridernewsDaoImpl implements ridernewsDao {
    public List<rider> getriderList(Connection connection) throws  Exception{
    String sql = "select * from rider";
    PreparedStatement pstm;
    ResultSet rs;
    List<rider> riderList = new ArrayList<rider>();
    pstm=connection.prepareStatement(sql);
    rs=pstm.executeQuery();
    while(rs.next()){
        int id = rs.getInt(1);
        long phone = rs.getLong(2);
        String name = rs.getString(3);
        String id_card=rs.getString(4);
        byte[] driver_license=rs.getBytes(5);
        long bank_card=rs.getLong(6);
        String work_city=rs.getString(7);
        String status=rs.getString(8);
        String password=rs.getString(9);
        int ad_id =rs.getInt(10);
        riderList.add(new rider(id,phone,name,id_card,driver_license,bank_card,work_city,status,password,ad_id));
    }
    return riderList;
}
}
