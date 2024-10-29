package com.gyd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	

	private final static String DRVIER="com.mysql.cj.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost/test?characterEncoding=utf-8&serverTimezone=UTC";
	private final static String USER="root";
	private final static String PASSWORD="123456";
	
	
	public static Connection getConn() {
		Connection conn=null;
		try {
			Class.forName(DRVIER);
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;
		
	}
	
	public static void closeResources(Connection conn,PreparedStatement pstm,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();				
			}
			if(pstm!=null) {
				pstm.close();				
			}
			if(conn!=null) {
				conn.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
