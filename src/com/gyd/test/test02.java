package com.gyd.test;

import com.gyd.jdbc03.InsertStu;
import com.gyd.jdbc03.Login;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {

        InsertStu s1 = new InsertStu();
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------欢迎进入武汉厚薄饭卡业务系统--------------------");
        System.out.println("1.登录界面, 请按1");
        System.out.println("2.注册页面, 请按2");
        System.out.println("0.退出系统, 请按0");

        int code=sc.nextInt();

        if (code==1){

            Login l1 = new Login();

            l1.selectOne();



        }else if (code==2){
            s1.insertStu();
        }else if (code==0){
            System.out.println("退出系统");
            System.exit(0);
        }


    }
}
