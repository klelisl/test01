package com.gyd.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {

        //定义字符串保存读取所有内容
        StringBuffer sb=new StringBuffer();


        //创建一个读取文件对象
        File f1=new File("e:\\abc\\a.txt");


        try {
            //创建文件字节输入流对象(读取)
            FileInputStream fis=new FileInputStream(f1);

            //缓冲区
            byte[] b=new byte[200];

            //检查是否读取完毕,如果文件读取完毕,read(byte[] b)返回-1,否则返回读取到的字节数
            //int hasRead = fis.read(b);  //获取从缓冲区中读取到字节数
            //System.out.println("读取字节数"+hasRead);
            int hasRead=0;
            while ((hasRead= fis.read(b))>0){
                System.out.println("读取字节数"+hasRead);
                //将读取内容保存StringBuffer中
                sb.append(new String(b,0,hasRead));
            }

            //显示读取内容
            System.out.println(sb);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
