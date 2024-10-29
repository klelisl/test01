package com.gyd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gyd.entity.UserEntity;
import com.gyd.util.DBConnection;

public class UserDao {
    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;

    //用户登录，返回统计结果
    public int login(String user_card, String user_password) {
        //定义统计结果
        int count=0;

        try {
            conn= DBConnection.getConn();
            String sql="select count(*) from user where user_card=? and user_password=?";
            pstm=conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, user_card);
            pstm.setString(2, user_password);
            //返回结果集
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取统计结果
                count=rs.getInt(1); //1 表示返回结果集中列的排列顺序
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }

        return  count;

    }

    public int user_action(String user_card) {

        int count1=0;
        try {
            conn = DBConnection.getConn();
            String sql="select * from user where user_card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, user_card);
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取每一行记录(变量)
                int user_action=rs.getInt("user_action");
                count1=count1+user_action;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }

        return count1;
    }

    public int updateUser(String card) {
        //定义受影响行数
        int count2=0;

        try {
            conn= DBConnection.getConn();
            String sql="update user user_action=1 where card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, card);
            count2= pstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }


        return count2;
    }

    public void selectAll(String card) {

        try {
            conn = DBConnection.getConn();
            String sql="select * from user where user_card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, card);
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取每一行记录(变量)
                int user_card=rs.getInt("user_card");
                String user_name=rs.getString("user_name");
                float user_money =rs.getFloat("user_money");
                int user_action=rs.getInt("user_action");

                System.out.println("卡号"+user_card+"姓名"+user_name+"余额"+user_money+"状态"+user_action);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }

    }
    //balance 余额;
    public void updateMoney(int balance,String card){

        //定义受影响行数
        int count=0;

        try {
            conn= DBConnection.getConn();
            String sql="update user user_money=user_money+? where card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, balance);
            pstm.setString(2,card);
            count= pstm.executeUpdate();
            if(count>0) {
                System.out.println("存款成功");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }
    }
//打印
//print
    public void  printMoney(int balance){

        System.out.println("您已存款"+balance+"元");

    }

    public float ATm_money(){
        float count=0;
        try {
            conn= DBConnection.getConn();
            String sql="select ATM_money from ATM where ATM_ID=1";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()) {
                count=count+rs.getFloat("ATM_money");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }
        return count;

    }

    public float user_money(String card){
        float count=0;
        try {
            conn= DBConnection.getConn();
            String sql="select user_money from user where card=?";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()) {
                count=count+rs.getFloat("user_money");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }
        return count;
    }
    //取款
    public void drawMoney(float amount,String card){
        float count=0;
        try {
            conn= DBConnection.getConn();
            String sql="update user user_money=user_money-? where card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setFloat(1, amount);
            pstm.setString(2,card);
            count= pstm.executeUpdate();
            if(count>0) {
                System.out.println("取款成功");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }
    }

    public void  printMoney1(float amount){

        System.out.println("您已取款"+amount+"元");

    }
    public int login3(String user_card) {
        //定义统计结果
        int count=0;

        try {
            conn= DBConnection.getConn();
            String sql="select count(*) from user where user_card=?";
            pstm=conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, user_card);

            //返回结果集
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取统计结果
                count=rs.getInt(1); //1 表示返回结果集中列的排列顺序
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }

        return  count;

    }

    public void selectAll1(String card) {

        try {
            conn = DBConnection.getConn();
            String sql="select * from user where user_card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, card);
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取每一行记录(变量)
                int user_card=rs.getInt("user_card");
                String user_name=rs.getString("user_name");
                int user_action=rs.getInt("user_action");

                System.out.println("卡号"+user_card+"姓名"+user_name+"状态"+user_action);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }

    }

    public int updateUser1(String card) {
        //定义受影响行数
        int count2=0;

        try {
            conn= DBConnection.getConn();
            String sql="update user set user_action=1 where card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, card);
            count2= pstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }


        return count2;
    }

    public void  printMoney2(String balance){

        System.out.println("您已转账"+balance+"元");

    }

    public String selectpwd(String card) {
        String count=null;

        try {
            conn = DBConnection.getConn();
            String sql="select user_password from user where user_card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, card);
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取每一行记录(变量)
                count=rs.getString("user_password");

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }
        return card;
    }

    public int updateUser12(String card,String password) {
        //定义受影响行数
        int count2=0;

        try {
            conn= DBConnection.getConn();
            String sql="update user set user_password=? where card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, card);
            pstm.setString(2, password);
            count2= pstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }


        return count2;
    }







}
