package com.gyd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo01 {
    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=studb2","sa","123456");
            PreparedStatement pstm=conn.prepareStatement("delete from stuinfo where stuid=1006");
            int num=pstm.executeUpdate();

            if (num>0){
                System.out.println("删除成功");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
