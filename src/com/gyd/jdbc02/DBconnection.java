package com.gyd.jdbc02;

import java.sql.*;

public class DBconnection {


    public static Connection getAll(){

        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC","root","123456");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static void closeAll(Connection conn,PreparedStatement pstm,ResultSet rs){
        try{
            if (rs!=null){
                rs.close();
            }
            if (pstm!=null){
                pstm.close();
            }
            if (conn!=null){
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
