package com.gyd.lianxi;

import com.gyd.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertDemo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号");
        int num = sc.nextInt();

        getone(num);


    }

    public static Student getone(int id) {

        Student stu = new Student();


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=studb2", "sa", "123456");

            String sql = "select *from stuinfo where stuid=" + id;
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                String stuname = rs.getString("stuName");
                String stusex = rs.getString("stuSex");
                int stuage = rs.getInt("stuAge");
                int stugid = rs.getInt("gid");

                stu.setStuName(stuname);
                stu.setStuSex(stusex);
                stu.setStuAge(stuage);
                stu.setGid(stugid);


                List<Student> studentList = new ArrayList<Student>();
                studentList.add(stu);


                //从集合中获取到学生信息
                for (int i = 0; i < studentList.size(); i++) {
                    //第一步:从集合中先获取学生对象
                    Student stu1 = studentList.get(i);
                    //第二步:从学生对象中获取到学生元素
                    int stuidd = stu.getStuid();
                    String stunamee = stu1.getStuName();
                    String stusexx = stu1.getStuSex();
                    int stuagee = stu1.getStuAge();

                    //输出
                    System.out.println(stuidd + stunamee + stusexx + stuagee);


                }

            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return stu;
    }
}