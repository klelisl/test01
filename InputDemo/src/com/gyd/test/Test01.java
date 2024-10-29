package com.gyd.test;

import java.io.File;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) {

        //创建一个file对象
        File f1=new File("e:\\test.txt");
        File f2=new File("e:\\","test.ppt");
        File f4=new File("a.txt");

        //创建一个file文件夹对象
        File f3=new File("e:\\abc");
        File f5=new File("e:\\abc\\a.txt");

        try {
            //创建文件
            boolean b1 = f1.createNewFile();
            boolean b2 = f2.createNewFile();
            boolean b4 = f4.createNewFile();


            //创建文件夹
            boolean b3 = f3.mkdir();
            boolean b5 = f5.mkdirs();
            //输出结果
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
            System.out.println(b4);
            System.out.println(b5);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
