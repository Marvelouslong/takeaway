package dao.impl;


import dao.BaseDao;
import dao.storeDao;
import pojo.store;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                shop.setBrand_authorization(rs.getBytes("brand_authorization"));
                shop.setBank_card(rs.getLong("bank_card"));
                shop.setLicense(rs.getBytes("license"));
                shop.setCertificate_of_business(rs.getBytes("certificate_of_business"));
                shop.setLegal_id_card(rs.getString("legal_id_card"));
                shop.setStatus(rs.getString("status"));
                shop.setShop_picture(rs.getBytes("shop_picture"));
                shop.setMain_category(rs.getString("main_category"));
                shop.setAuxiliary_category(rs.getString("auxiliary_category"));
                shop.setAd_id(rs.getInt("ad_id"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return shop;
    }
    //查看商店信息
    public List<store> getstoreList(Connection connection) throws  Exception{
        String sql = "select * from store";
        PreparedStatement pstm;
        ResultSet rs;
        List<store> storeList = new ArrayList<store>();
        pstm=connection.prepareStatement(sql);
        rs=pstm.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String address = rs.getString(2);
            long con_telephone = rs.getLong(3);
            String shop_name = rs.getString(4);
            String con_name=rs.getString(5);
            String password=rs.getString(6);
            byte[] brand_authorization=rs.getBytes(7);
            long bank_card=rs.getLong(8);
            byte[] license=rs.getBytes(9);
            byte[] certificate_of_business=rs.getBytes(10);
            String legal_id_card=rs.getString(11);
            String status=rs.getString(12);
            byte[] shop_picture=rs.getBytes(13);
            String main_category =rs.getString(14);
            String auxiliary_category=rs.getString(15);
            int ad_id =rs.getInt(16);
            storeList.add(new store(id,address,con_telephone,shop_name,con_name,password, brand_authorization,bank_card,  license,  certificate_of_business,legal_id_card,status,shop_picture,main_category,auxiliary_category,ad_id));
        }
        return storeList;
    }
    //修改状态
    public int modify(Connection connection, store shop) throws Exception {
        int updateNum = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update store set status=? where legal_id_card = ? ";
            Object[] params = {shop.getStatus(),shop.getLegal_id_card()};
            updateNum = BaseDao.execute(connection,pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateNum;
    }
}
//,shop_picture=?,main_category=?,auxiliary_category=?,ad_id=? ,password=?,bank_card=?,license=?,certificate_of_business=?,legal_id_card=?
//,shop.getPassword(),shop.getBrand_authorization(),shop.getBank_card(),shop.getLicense(),shop.getCertificate_of_business(),shop.getLegal_id_card(),
//,shop.getShop_picture(),shop.getMain_category(),shop.getAuxiliary_category(),shop.getAd_id()
//address=?,con_telephone=?,shop_name=?,con_name=?,shop.getAddress(),shop.getCon_telephone(),shop.getShop_name(),shop.getCon_name(),