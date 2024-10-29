package com.gyd.dao;

import com.gyd.entity.commodityInformationEntity;
import com.gyd.util.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class userinfoDao {

    private static Connection conn=null;
    private  static  PreparedStatement pstm=null;
    private static  ResultSet rs=null;
    //新增
    public int insertUserinfo(String user, String password,String uname){


        //定义数组保存数据
        Object [] obj = {user,password,uname};
        //定义sql语句
        String sql="insert into userInformation values(?,?,?,2,1)";

        //调用通用方法
        return BaseDao.executeUpdate(obj,sql);
    }

    public int insertSeller(String user, String password,String uname){

        //定义数组保存数据
        Object [] obj = {user,password,uname};
        //定义sql语句
        String sql="insert into userInformation values(?,?,?,1,1)";

        //调用通用方法
        return BaseDao.executeUpdate(obj,sql);
    }


    public int login(String user, String password) {
        //定义统计结果
        int count=0;

        try {
            conn= DBconnection.getConnection();
            String sql="select count(*) from userInformation where user=? and password=?";
            pstm=conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, user);
            pstm.setString(2, password);
            //返回结果集
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取统计结果
                count=rs.getInt(1); //1 表示返回结果集中列的排列顺序
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBconnection.closeResources(conn, pstm, rs);
        }

        return  count;

    }

    public int loginChioce(String user) {
        //定义统计结果
        int count=0;

        try {
            conn= DBconnection.getConnection();
            String sql="select roleid from userInformation where user=? ";
            pstm=conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, user);
            //返回结果集
            rs=pstm.executeQuery();

            while(rs.next()) {
                //获取统计结果
                count=rs.getInt(1); //1 表示返回结果集中列的排列顺序
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            DBconnection.closeResources(conn, pstm, rs);
        }

        return  count;

    }

    public static List<commodityInformationEntity> commodityInformationSelect(){
        List<commodityInformationEntity> commodityInformationList=new ArrayList<>();

        try{
            conn= DBconnection.getConnection();
            String sql="select * from commodityInformation";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();

            while(rs.next()){
                int commodityid=rs.getInt("commodityid");
                String commodityname=rs.getString("commodityname");
                int typeid=rs.getInt("typeid");
                String brand=rs.getString("brand");
                double price=rs.getDouble("price");
                String productiondate=rs.getString("productiondate");
                String expirationdate=rs.getString("expirationdate");


                //创建一个商品信息对象
                commodityInformationEntity commodityInformation=new commodityInformationEntity();
                commodityInformation.setCommodityid(commodityid);
                commodityInformation.setCommodityName(commodityname);
                commodityInformation.setTyped(typeid);
                commodityInformation.setBrand(brand);
                commodityInformation.setPrice(price);
                commodityInformation.setProductiondate(productiondate);
                commodityInformation.setExpirationdate(expirationdate);

                commodityInformationList.add(commodityInformation);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return commodityInformationList;
    }
    public int insertshopCar(String user, String password,String uname){

        System.out.println();
        //定义数组保存数据
        Object [] obj = {user,password,uname};
        //定义sql语句
        String sql="insert into userInformation values(?,?,?,2,1)";

        //调用通用方法
        return BaseDao.executeUpdate(obj,sql);
    }




}
