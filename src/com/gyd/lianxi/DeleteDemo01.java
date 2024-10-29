package com.gyd.lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

public class DeleteDemo01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        int id=sc.nextInt();

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=studb3","sa","123456");
            String sql="delete from stuinfo where stuid="+id;
            PreparedStatement pstm=conn.prepareStatement(sql);
            int num= pstm.executeUpdate();

            if (num>0){
                System.out.println("删除成功");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
