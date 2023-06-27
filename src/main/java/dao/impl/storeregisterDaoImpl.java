package dao.impl;

import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.storeregisterDao;
import pojo.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class storeregisterDaoImpl implements storeregisterDao {
    @Override
    public Integer add(store Store) {
        Connection connection = BaseDao.getConnection();
        String sql = "insert into store(address,con_telephone,shop_name,con_name,password,brand_authorization,bank_card,license,certificate_of_business,legal_id_card,status,shop_picture,main_category,auxiliary_category,ad_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            Blob blob = (Blob) connection.createBlob();
            blob.setBytes(1, Store.brand_authorization());
            blob.setBytes(2,Store.license());
            blob.setBytes(3,Store.certificate_of_business());
            blob.setBytes(4,Store.shop_picture());
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, Store.getAddress());
            pstm.setLong(2, Store.getCon_telephone());
            pstm.setString(3, Store.getShop_name());
            pstm.setString(4, Store.getCon_name());
            pstm.setString(5,Store.getPassword());
            pstm.setString(6, Store.getLegal_id_card());
            pstm.setLong(7, Store.getBank_card());
            pstm.setString(8, Store.getStatus());
            pstm.setString(9, Store.getAuxiliary_category());
            pstm.setString(10,Store.getMain_category());
            pstm.setBlob(11,blob);
            pstm.setBlob(12,blob);
            pstm.setBlob(13,blob);
            pstm.setBlob(14,blob);
            pstm.setInt(15,Store.getAd_id());
            rs = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
}
