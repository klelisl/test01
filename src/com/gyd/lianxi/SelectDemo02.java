package com.gyd.lianxi;

import java.sql.*;
import java.util.Scanner;

public class SelectDemo02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        int id= sc.nextInt();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=studb3","sa","123456");
            String sql="select *from stuScore where stuid="+id;
            PreparedStatement pstm=conn.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                int scoreid= rs.getInt("id");
                int subId= rs.getInt("subId");
                int score=rs.getInt("score");

                System.out.println("成绩编号"+scoreid+"课程编号"+subId+"成绩"+score);

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
