package com.carManager.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtils {
    //使用c3p0实现数据库连接
    private static DataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return  dataSource;
    }

    public static Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String conditionSearch(String sql, String condition, String str){
        if(!"".equals(condition)&& condition != null){
            sql += "and "+str+" like '%"+condition+"%'";
        }
        return sql;
    }
    public static String conditionSearch(String sql, String date, String condition1, String condition2){
        if(!"".equals(condition1)&&!"".equals(condition2)){
            sql += "and "+ date +" between '"+condition1+"' and '"+condition2+"'" ;
        }
        return sql;
    }
}
