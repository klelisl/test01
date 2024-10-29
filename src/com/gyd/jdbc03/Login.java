package com.gyd.jdbc03;

import com.gyd.jdbc02.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;

    Scanner sc=new Scanner(System.in);
    int id=0;

    public void selectOne() {

        System.out.println("请输入学号");
        int num=sc.nextInt();
        System.out.println("请输入密码");
        String password=sc.next();
        id=num;

        try {
            conn= DBconnection.getAll();
            String sql="select * from card where id=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, num);
            rs=pstm.executeQuery();

            if (rs.next()) {
                String pwd=rs.getString("password");
                if (password.equals(pwd)) {

                    System.out.println("登录成功");

                    System.out.println("------------欢迎使用饭卡系统-----------");
                    System.out.println("1.充值饭卡。           请按1");
                    System.out.println("2.查询余额。           请按2");
                    System.out.println("3.查询信息。           请按3");
                    System.out.println("4.饭卡消费。           请按4");
                    System.out.println("5.查询银行卡上余额。     请按5");
                    System.out.println("6.修改信息。           请按6");
                    System.out.println("7.退出系统。           请按7");

                    int cout=sc.nextInt();

                    if (cout==1) {
                        InsertMoney();
                    }else if (cout==2) {
                        selectMoneyStuInfo();
                    }else if (cout==3) {
                        selectALLStuInfo();
                    }else if (cout==4) {
                        UpdateMoney();
                    }else if (cout==5) {
                        selectnumofbankcardStuInfo();
                    }else if (cout==6) {
                        updateALLStuInfo();
                    }else if (cout==7) {
                        System.out.println("退出系统");
                        System.exit(0);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void InsertMoney(){

        System.out.println("请输入您要充值的金额");
        float num=sc.nextFloat();

        try {
            conn=DBconnection.getAll();
            String sql="update card set money=money+?,numofbankcard=numofbankcard-? where id=?";

            pstm=conn.prepareStatement(sql);

            pstm.setFloat(1,num);
            pstm.setFloat(2,num);
            pstm.setInt(3,id);

            int num1 =pstm.executeUpdate();

            if (num1 >0){
                System.out.println("充值成功");
                selectMoneyStuInfo();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void selectMoneyStuInfo(){

        try {
            conn=DBconnection.getAll();
            String sql="select money  from card where id=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();

            while (rs.next()){
                Float money=rs.getFloat("money");

                System.out.println("您卡上的余额为"+money);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void selectALLStuInfo(){

        try {
            conn=DBconnection.getAll();
            String sql="select * from card where id=?";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();

            while (rs.next()){
                String id= rs.getString("id");
                String name =rs.getString("name ");
                String class_name= rs.getString("class_name");
                int money=rs.getInt("money");
                String password=rs.getString("password");
                float numofbankcard=rs.getFloat("numofbankcard");

                System.out.println(id+" "+ name +" "+class_name+" "+money+" "+password+" "+numofbankcard);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void UpdateMoney(){

        System.out.println("请输入您要花费的金额");
        float num=sc.nextFloat();

        try {
            conn=DBconnection.getAll();
            String sql="update card set money=money-? where id=?";

            pstm=conn.prepareStatement(sql);

            pstm.setFloat(1,num);
            pstm.setInt(2,id);

            int num1 =pstm.executeUpdate();

            rs=pstm.executeQuery();

            while (rs.next()){
                float money=rs.getFloat("money");
                if (num1 >0){
                    System.out.println("您已消费"+num+"元"+",卡上余额为"+money);
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void selectnumofbankcardStuInfo(){

        try {
            conn=DBconnection.getAll();
            String sql="select numofbankcard from card where id=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();

            while (rs.next()){
                Float numofbankcard=rs.getFloat("numofbankcard");

                System.out.println("银行卡金额为"+numofbankcard);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }
    public void updateCard(){

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

    public void updateALLStuInfo(){

        try {
            conn=DBconnection.getAll();
            String sql="select * from card where id=?";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();

            while (rs.next()){
                String id= rs.getString("id");
                String name =rs.getString("name ");
                String class_name= rs.getString("class_name");
                int money=rs.getInt("money");
                String password=rs.getString("password");
                float numofbankcard=rs.getFloat("numofbankcard");

                System.out.println("您当前的信息为:");
                System.out.println("您饭卡的完整信息为:");
                System.out.println("班级："+class_name);
                System.out.println("学号:"+id);
                System.out.println("姓名:"+name);


            }
            System.out.println("您确定修改信息吗？ 按1确认，其他推出修改");
            int num3=sc.nextInt();
            if (num3==1){
                System.out.println("您已确认修改");
                updateStu();
            }else {
                System.out.println("退出系统");
                System.exit(0);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBconnection.closeAll(conn,pstm,rs);
        }

    }

    public void updateStu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号");
        String id=sc.next();
        System.out.println("请输入用户名");
        String name=sc.next();
        System.out.println("请输入班级名");
        String class_name= sc.next();
        System.out.println("请输入密码");
        String password=sc.next();



        try {
            conn=DBconnection.getAll();
            String sql="update stuinfo set id=?,name=?,class_name=?,password=? where id=?";
            pstm=conn.prepareStatement(sql);

            pstm.setString(1,id);
            pstm.setString(2,name);
            pstm.setString(3,class_name);
            pstm.setString(4,password);


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



}

