package com.gyd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDemo01 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入姓名");
        String name=sc.nextLine();
        System.out.println("请输入性别");
        String sex=sc.nextLine();
        System.out.println("请输入年龄");
        int age=sc.nextInt();

        String info=name+","+sex+","+age+","+null+","+null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=studb2","sa","123456");
            String sql="insert into stuinfo values ('"+name+"','"+sex+"','"+age+"',null,null)";
            PreparedStatement pstm=conn.prepareStatement(sql);
            int num=pstm.executeUpdate();
            if (num>0){
                System.out.println("新增成功");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
