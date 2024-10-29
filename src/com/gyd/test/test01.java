package com.gyd.test;

import com.gyd.jdbc02.StudentInfo;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        StudentInfo s1=new StudentInfo();

        System.out.println("--------------------------学生管理系统-------------------------------");
        System.out.println("--1.查询所有  2.新增学生  3.修改学生 4.删除学生 5.根据学号查询学生  6.退出---");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("请输入操作编号");

        int code= sc.nextInt();

        if (code==1){
            s1.selectALLStuInfo();
        } else if (code==2) {
            s1.insertStu();
        } else if (code==3) {
            s1.updateStu();
        } else if (code==4) {
            s1.deleteStu();
        } else if (code==5) {
            s1.selectOneStu();
        } else if (code==6) {
            System.out.println("退出系统");
            System.exit(0);
        }else {
            System.out.println("输出错误");

        }


    }
}
