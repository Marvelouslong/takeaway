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
//        static DBUtil dbu = null;
//
//        public photoDaoImpl(){
//            dbu = DBUtil.getDBUtil();
//        }
        /**
         * 通过书籍id查询书籍图片
         */
        public byte[] queryphoto(int id) {
            // TODO Auto-generated method stub
            String sql = "select brand_authorization from store where id = ? ";
            byte[] picture = null;
            try{
                conn = BaseDao.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    picture = rs.getBytes(1);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                BaseDao.closeResource(null, ps, rs);
            }

            return picture;
        }
}
