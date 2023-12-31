package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    //静态代码块,在类加载的时候执行
    static {
        init();
    }

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //初始化连接参数,从配置文件里获得
    public static void init(){
        Properties properties = new Properties();
        String configFile = "db.properties";
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(configFile);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection connection =null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,password);
            System.out.println("yes");
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }


    /**
     * 编写查询公共类
     */
    public static ResultSet execute(Connection connection,PreparedStatement pstm,ResultSet rs,String sql,Object[] params)throws Exception{
        pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1,params[i]);
        }
        rs=pstm.executeQuery();
        return rs;
    }

    /**
     * 编写增删改公共类
     */
    public static int execute(Connection connection,PreparedStatement pstm,
                              String sql,Object[] params) throws Exception{
        int updateRows = 0;
        pstm = connection.prepareStatement(sql);
        for(int i = 0; i < params.length; i++){
            pstm.setObject(i+1, params[i]);
        }
        updateRows = pstm.executeUpdate();
        return updateRows;
    }

    /**
     * 释放资源
     */
    public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag = true;
        if(rs != null){
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(pstm != null){
            try {
                pstm.close();
                pstm = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                connection = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }
}
