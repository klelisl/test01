package com.gyd.jdbc;

import java.sql.*;

public class Sql1 {
    public static void main(String[] args) {

        Sql1.jd();
    }


        public static void jd() {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            //定义数据库用户
            String userName = "sa";
            //定义数据库密码
            String userPwd = "123456";
            String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=studb2";
            try {
                //1.加载及注册驱动
                Class.forName(driverName);
                //2.数据库连接
                Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
                System.out.println("连接数据库成功");
                //4.定义SQL语句
                String sql = "select * from stuinfo";
                //5.创建一个执行sql对象
                PreparedStatement stmt = conn.prepareStatement(sql);
                //6.执行SQL语句命令
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    int stuid = resultSet.getInt(1);
                    String stuname = resultSet.getString(2);
                    String stusex = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    System.out.println(stuid+" "+stusex+" "+age);
                }


            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("连接失败");

            }
        }

}
