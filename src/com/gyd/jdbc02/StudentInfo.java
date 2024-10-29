package com.gyd.jdbc02;

import java.sql.*;
import java.util.Scanner;

public class StudentInfo {
    private Connection conn=null;
    private  PreparedStatement pstm=null;
    private ResultSet rs=null;



    public void selectALLStuInfo(){

        try {
            conn=DBconnection.getAll();
            String sql="select *from stuinfo";
             pstm=conn.prepareStatement(sql);
             rs=pstm.executeQuery();

            while (rs.next()){
                int stuid= rs.getInt("stuid");
                String sname=rs.getString("stuname");
                 String stusex= rs.getString("stusex");

                System.out.println(stuid+" "+sname+" "+stusex);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void insertStu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入姓名");
        String name=sc.nextLine();
        System.out.println("请输入性别");
        String sex= sc.next();


        try {
            conn=DBconnection.getAll();
            String sql="insert into stuinfo values (null,?,?)";
             pstm=conn.prepareStatement(sql);
            pstm.setString(1,name);
            pstm.setString(2,sex);

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

    public void updateStu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        int id=sc.nextInt();
        System.out.println("请输入姓名");
        String name=sc.next();
        System.out.println("请输入性别");
        String sex= sc.next();


        try {
            conn=DBconnection.getAll();
            String sql="update stuinfo set stuname=?,stusex=? where stuid=?";
             pstm=conn.prepareStatement(sql);

            pstm.setString(1,name);
            pstm.setString(2,sex);
            pstm.setInt(3,id);

            int num=pstm.executeUpdate();

            if (num>0){
                System.out.println("修改成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }
    }

    public void deleteStu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        int id= sc.nextInt();

        try {

            String sql="delete from stuinfo where stuid=?";
             pstm=conn.prepareStatement(sql);
            pstm.setInt(1,id);

            int num=pstm.executeUpdate();

            if (num>0){
                System.out.println("删除成功");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void selectOneStu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        int id= sc.nextInt();

        try {
            conn=DBconnection.getAll();
             String sql="select  * from stuinfo where stuid=?";
              pstm=conn.prepareStatement(sql);
             pstm.setInt(1,id);

              rs=pstm.executeQuery();

             while (rs.next()){
                 int stuid= rs.getInt("stuid");
                 String stuname= rs.getString("stuname");
                 String sex= rs.getString("stusex");

                 System.out.println(stuid+" "+stuname+" "+sex);


             }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void selectNameStu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入姓氏");
        String id= sc.next();

        try {
            conn=DBconnection.getAll();
            String sql="SELECT * FROM stuinfo where stuname LIKE  \"%\"?\"%\" ";
             pstm=conn.prepareStatement(sql);

            pstm.setString(1,id);

             rs=pstm.executeQuery();

            while (rs.next()){
                int sid= rs.getInt("stuid");
                String sname= rs.getString("stuname");
                String sex= rs.getString("stusex");

                System.out.println(sid+" "+sname+" "+sex);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBconnection.closeAll(conn,pstm,rs);
        }


    }



}







