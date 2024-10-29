package com.gyd.test;

import java.io.File;

public class Test02 {
    public static void main(String[] args) {

        //创建一个file对象
        File f1=new File("e:\\abc\\a.txt");

        //方法
        String path1=f1.getAbsolutePath(); //绝对路径
        String name1=f1.getName();  //获取文件名
        String parent1=f1.getParent(); //获取父级目录
        String path=f1.getPath(); //获取路径

        boolean b1=f1.exists();  //判断文件是否存在

        System.out.println(path1);
        System.out.println(name1);
        System.out.println(parent1);
        System.out.println(path1);



    }
}
