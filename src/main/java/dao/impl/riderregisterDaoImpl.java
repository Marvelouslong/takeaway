package dao.impl;

import dao.riderregisterDao;
import pojo.rider;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class riderregisterDaoImpl implements riderregisterDao {
    @Override
    public List<rider> list(int ad_id) {
        return null;
    }

    @Override
    public List<rider> list(String ad_id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from Rider where ad_id = '" + ad_id + "'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<rider> list = new ArrayList<rider>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                long phone = resultSet.getLong(2);
                String name = resultSet.getString(3);
                String id_card = resultSet.getString(4);
                Blob driver_license = resultSet.getBlob(5);
                long bank_card = resultSet.getLong(6);
                String work_city = resultSet.getString(7);
                String password = resultSet.getString(8);
                list.add(new rider(id, phone, name, id_card, (com.mysql.cj.jdbc.Blob) driver_license, bank_card, work_city, password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<rider> list1() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from Rider";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<rider> list1 = new ArrayList<rider>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                long phone = resultSet.getLong(2);
                String name = resultSet.getString(3);
                String id_card = resultSet.getString(4);
                Blob driver_license = resultSet.getBlob(5);
                long bank_card = resultSet.getLong(6);
                String work_city = resultSet.getString(7);
                String status = resultSet.getString(8);
                String psaaword = resultSet.getString(9);
                int ad_id = resultSet.getInt(10);


                list1.add(new rider(id, phone, name, id_card, (com.mysql.cj.jdbc.Blob) driver_license, bank_card, work_city, psaaword, status, ad_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list1;
    }

    public List<rider> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from classroom where " + key + " like '%" + value + "%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<rider> list1 = new ArrayList<rider>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                long phone = resultSet.getLong(2);
                String name = resultSet.getString(3);
                String id_card = resultSet.getString(4);
                Blob driver_license = resultSet.getBlob(5);
                long bank_card = resultSet.getLong(6);
                String work_city = resultSet.getString(7);
                String status = resultSet.getString(8);
                String password = resultSet.getString(9);
                int ad_id = resultSet.getInt(10);
                list1.add(new rider(id, phone, name, id_card, (com.mysql.cj.jdbc.Blob) driver_license, bank_card, work_city, status, password, ad_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list1;
    }

    public Integer save(rider Rider) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into Rider(id,phone,name,id_card,driver_license,bank_card,work_city,status,password) values(?,?,?,?,?,?,?,?,?) ";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Rider.getId());
            statement.setLong(2, Rider.getPhone());
            statement.setString(3, Rider.getName());
            statement.setString(4, Rider.getId_card());
            statement.setBlob(5, Rider.getDriver_license());
            statement.setLong(6, Rider.getBank_card());
            statement.setString(7, Rider.getWork_city());
            statement.setString(8, Rider.getStatus());
            statement.setString(9, Rider.getPassword());
            //statement.setInt(10,Rider.getAd_id());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public Integer del(rider Rider) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from Rider where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Rider.getId());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public Integer del(int id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from Rider where id = " + id;
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public Integer update(rider Rider) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update classroom set phone = ?,name = ?,id_card= ?,driver_license = ?,bank_card = ?,work_city = ?, status = ?,password = ? ad_id = ? where id =?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Rider.getId());
            statement.setLong(2, Rider.getPhone());
            statement.setString(3, Rider.getName());
            statement.setString(4, Rider.getId_card());
            statement.setBlob(5, Rider.getDriver_license());
            statement.setLong(6, Rider.getBank_card());
            statement.setString(7, Rider.getWork_city());
            statement.setString(8, Rider.getStatus());
            statement.setString(9, Rider.getPassword());
            statement.setInt(10, Rider.getAd_id());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public Integer update1(rider Rider) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update Rider set id = ? where ad_id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Rider.getId());
            statement.setInt(2, Rider.getAd_id());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }
}
