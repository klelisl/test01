package com.gyd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;

public class UpdateDemo01 {
    public static void main(String[] args) {

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

           Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=studb2;","sa","123456");
            PreparedStatement pstm=conn.prepareStatement("update stuinfo set stusex='男' where stuid=1005");
            int num=pstm.executeUpdate();

            if (num>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
