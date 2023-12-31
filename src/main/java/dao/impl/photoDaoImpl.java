package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.BaseDao;
import dao.photoDao;

public class photoDaoImpl implements photoDao {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        public byte[] querybrand_authorization(int id) {
            String sql = "select brand_authorization from store where id = ? ";
            byte[] picturebrand_authorization = null;
            try{
                conn = BaseDao.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    picturebrand_authorization = rs.getBytes(1);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                BaseDao.closeResource(null, ps, rs);
            }

            return picturebrand_authorization;
        }
       public byte[] querylicense(int id) {
        // TODO Auto-generated method stub
         String sql = "select license from store where id = ? ";
         byte[] picturelicense = null;
         try{
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                picturelicense = rs.getBytes(1);
            }
         }catch(Exception e){
            e.printStackTrace();
         }finally{
            BaseDao.closeResource(null, ps, rs);
        }

          return picturelicense;
    }
    public byte[] querycertificate_of_business(int id) {
        // TODO Auto-generated method stub
        String sql = "select certificate_of_business from store where id = ? ";
        byte[] picturecertificate_of_business = null;
        try{
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                picturecertificate_of_business = rs.getBytes(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, ps, rs);
        }

        return picturecertificate_of_business;
    }
    public byte[] queryshop_picture(int id) {
        // TODO Auto-generated method stub
        String sql = "select shop_picture from store where id = ? ";
        byte[] pictureshop_picture = null;
        try{
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                pictureshop_picture = rs.getBytes(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, ps, rs);
        }
        return pictureshop_picture;
    }

    public byte[] picturedishes_picture(int id) {
        // TODO Auto-generated method stub
        String sql = "select picture from dishes where id = ? ";
        byte[] picturedishes_picture = null;
        try{
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                picturedishes_picture = rs.getBytes(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, ps, rs);
        }
        return picturedishes_picture;
    }
    public byte[] querydriver_license(int id) {
        // TODO Auto-generated method stub
        String sql = "select driver_license from rider where id = ? ";
        byte[] picturedriver_license = null;
        try{
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                picturedriver_license = rs.getBytes(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, ps, rs);
        }
        return picturedriver_license;
    }

    public byte[] eva(int id) {
        // TODO Auto-generated method stub
        String sql = "select picture from evaluate where id = ? ";
        byte[] eva = null;
        try{
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                eva = rs.getBytes(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, ps, rs);
        }
        return eva;
    }
}
