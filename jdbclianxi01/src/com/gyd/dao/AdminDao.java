package com.gyd.dao;

import com.gyd.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;

    public int login(String admin_id, String admin_password) {
        //定义统计结果
        int count=0;

        try {
            conn= DBConnection.getConn();
            String sql="select count(*) from admin where admin_id=? and admin_password=?";
            pstm=conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, admin_id);
            pstm.setString(2, admin_password);
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

    public int admin_action(String user_card) {

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
    public int updateAdmin(String admin_id) {
        //定义受影响行数
        int count2=0;

        try {
            conn= DBConnection.getConn();
            String sql="update user user_action=1 where card=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, admin_id);
            count2= pstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBConnection.closeResources(conn, pstm, rs);
        }


        return count2;
    }



}
