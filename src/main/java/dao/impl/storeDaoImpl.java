package dao.impl;


import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.storeDao;
import pojo.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class storeDaoImpl implements storeDao {
    public store getLoginStore(Connection connection, long con_telephone) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        store shop=null ;
        if (connection != null) {
            String sql= "select * from store where con_telephone=?";
            Object[] params={con_telephone};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()){
                shop=new store();
                shop.setId(rs.getInt("id"));
                shop.setAddress(rs.getString("address"));
                shop.setCon_telephone(rs.getLong("con_telephone"));
                shop.setShop_name(rs.getString("shop_name"));
                shop.setCon_name(rs.getString("con_name"));
                shop.setPassword(rs.getString("password"));
                shop.setBrand_authorization((Blob) rs.getBlob("brand_authorization"));
                shop.setBank_card(rs.getLong("bank_card"));
                shop.setLicense((Blob) rs.getBlob("license"));
                shop.setCertificate_of_business((Blob) rs.getBlob("certificate_of_business"));
                shop.setLegal_id_card(rs.getString("legal_id_card"));
                shop.setStatus(rs.getString("status"));
                shop.setShop_picture((Blob) rs.getBlob("shop_picture"));
                shop.setMain_category(rs.getString("main_category"));
                shop.setAuxiliary_category(rs.getString("auxiliary_category"));
                shop.setAd_id(rs.getInt("ad_id"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return shop;
    }
}
