package com.gyd.dao;

import com.gyd.entity.stugradeEntity;
import com.gyd.entity.stuinfooEntity;
import com.gyd.entity.stuscoreEntity;
import com.gyd.entity.stusubjectEntity;
import com.gyd.util.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuInfoDao {

    private static Connection conn=null;
    private static PreparedStatement pstm=null;
    private static ResultSet rs=null;

    //修改方法
    public int updateStuInfo(int stuid,String stuname,String stusex){

        //定义数组保存数据
        Object [] obj = {stuname,stusex,stuid};
        //定义sql语句
        String sql="update stuinfo set stuname=?,stusex=? where stuid=?";

        //调用通用方法
        return BaseDao.executeUpdate(obj,sql);
    }

    //多表查询
    public  List<stuscoreEntity>  selectScore(){
        List<stuscoreEntity> scoreList=new ArrayList<>();

        try{
            conn= DBconnection.getConnection();
            String sql="select  stuScore.stuid,stuname,stuAge,subid,score from stuScore,stuInfoo where stuScore.stuid=stuinfoo.stuid ";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();

            while(rs.next()){
                int stuid=rs.getInt("stuid");
                int subid=rs.getInt("subid");
                int score=rs.getInt("score");
                int stuAge=rs.getInt("stuAge");
                String stuName=rs.getString("stuname");

                //创建一个成绩对象
                stuscoreEntity stuscore=new stuscoreEntity();
                stuscore.setStuid(stuid);
                stuscore.setSubid(subid);
                stuscore.setScore(score);

                //创建一个学生对象
                stuinfooEntity stuinfoo=new stuinfooEntity();
                stuinfoo.setStuname(stuName);
                stuinfoo.setStuAge(stuAge);

                //将学生对象添加到成绩对象中
                stuscore.setStuinfoo(stuinfoo);

                scoreList.add(stuscore);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scoreList;
    }

    public  List<stuscoreEntity>  selectScoree(){
        List<stuscoreEntity> scoreeList=new ArrayList<>();

        try{
            conn= DBconnection.getConnection();
            String sql="SELECT stuinfoo.stuid,stuname,gname,subName,score FROM stuinfoo,stugrade,stuscore,stusubject WHERE stuScore.stuid=stuinfoo.stuid AND stuinfoo.gid=stugrade.gid AND stuscore.subid=stusubject.subid;";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();

            while(rs.next()){
                int stuid=rs.getInt("stuid");
                int score=rs.getInt("score");
                String gname=rs.getString("gname");
                String subName=rs.getString("subName");
                String stuName=rs.getString("stuname");

                //创建一个成绩对象
                stuscoreEntity stuscore=new stuscoreEntity();
                stuscore.setStuid(stuid);
                stuscore.setScore(score);

                //创建一个学生对象
                stuinfooEntity stuinfoo=new stuinfooEntity();
                stuinfoo.setStuname(stuName);
                //创建一个班级对象
                stugradeEntity stugrade=new stugradeEntity();
                stugrade.setGname(gname);
                //创建一个科目对象
                stusubjectEntity stusubject=new stusubjectEntity();
                stusubject.setSubName(subName);

                //将学生对象添加到成绩对象中
                stuscore.setStuinfoo(stuinfoo);
                //将科目对象添加到成绩对象中
                stuscore.setStusubjectEntity(stusubject);
                //将班级对象添加到学生对象中
                stuinfoo.setStugradeEntity(stugrade);

                //将成绩对象添加到集合中
                scoreeList.add(stuscore);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scoreeList;
    }






}
