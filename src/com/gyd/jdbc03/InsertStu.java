package com.gyd.jdbc03;

import com.gyd.jdbc02.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStu {

    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;

    public void insertStu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        String id=sc.nextLine();
        System.out.println("请输入姓名");
        String name=sc.nextLine();
        System.out.println("请输入班级名称");
        String cname= sc.next();
        System.out.println("请输入余额");
        float money=sc.nextFloat();
        System.out.println("请输入密码");
        String pwd=sc.next();
        System.out.println("请输入银行卡金额");
        float ncal=sc.nextFloat();


        try {
            conn= DBconnection.getAll();
            String sql="insert into card values(?,?,?,?,?,?);";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,id);
            pstm.setString(2,name);
            pstm.setString(3,cname);
            pstm.setFloat(4,money);
            pstm.setString(5,pwd);
            pstm.setFloat(6,ncal);


            int num=pstm.executeUpdate();

            if (num>0){
                System.out.println("新增成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBconnection.closeAll(conn,pstm,rs);
        }
    }
}
