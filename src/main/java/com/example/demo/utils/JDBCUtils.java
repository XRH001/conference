package com.example.demo.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.util.JdbcUtils;

import java.beans.Statement;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";

    public static DruidDataSource druidDataSource;
    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream =JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//             JdbcUtils.class.getClassLoader.getResourceAsStream();
            properties.load(inputStream);
            druidDataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        System.out.println(getConnection());
    }

    /**
     * 获取连接池中的连接
     * @return 如果返回null,则说明获取失败
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= druidDataSource.getConnection();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;

    }

    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
