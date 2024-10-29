package com.gyd.lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class SelectDemo01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        int id= sc.nextInt();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=studb3","sa","123456");
            String sql="select *from stuinfo where stuId="+id;
           PreparedStatement pstm= conn.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){

                String stuname= rs.getString("stuname");
                String stusex= rs.getString("stusex");
                int stuage=rs.getInt("stuage");

                System.out.println(" "+stuname+" "+stuage+" "+stusex);
            }

        }catch (Exception ex){
           ex.printStackTrace();
        }


    }
}
