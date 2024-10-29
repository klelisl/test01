package com.gyd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo01 {
    public static void main(String[] args) {

        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.使用DriverManager对象管理驱动，返回Connection连接对象
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=studb2","sa","123456");
            //3.使用Connection对象获取PreparedStatement执行对象
            PreparedStatement pstm=conn.prepareStatement("select *from stuinfo");
            ResultSet rs=pstm.executeQuery();
            System.out.println(conn);

            while (rs.next()){
                int stuid=rs.getInt("stuid");
                String stuname= rs.getString("stuname");
                String stusex= rs.getString("stusex");
                int stuage=rs.getInt("stuage");

                System.out.println(stuid+" "+stuname+" "+stuage+" "+stusex);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
