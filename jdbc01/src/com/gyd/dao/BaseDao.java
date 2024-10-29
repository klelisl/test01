package com.gyd.dao;

import com.gyd.util.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private static Connection conn=null;
    private static PreparedStatement pstm=null;
    private static ResultSet rs=null;

    //通用新增,删除,修改方法
    public static int executeUpdate(Object [] obj,String sql){
        //定义受影响行数
        int count=0;
        try {
            conn= DBconnection.getConnection();
            pstm=conn.prepareStatement(sql);
            //循环遍历设置参数与占位符绑定
            for(int i=0;i<obj.length;i++){
                pstm.setObject(i+1, obj[i]);
            }
            //执行sql语句，返回一个受影响行数
            count=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
