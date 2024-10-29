package com.gyd.test;

import java.io.*;

public class FileOutputStreamDemo01 {
    public static void main(String[] args) {
        try {
            //创建一个读取文件对象
            File f1 = new File("e:\\abc.png");
            //创建一个写入文件对象
            File f2 = new File("e:\\abc01.png");

            //创建一个字节输入流对象(读取)
            FileInputStream fis = new FileInputStream(f1);
            //创建一个字节输出流对象(写入)
            FileOutputStream fos = new FileOutputStream(f2);

            //创建读取缓冲区
            byte[] b = new byte[200];
            //判断文件是否读取完毕
            int hasRead = 0;
            while ((hasRead = fis.read(b)) > 0) {
                //获取读取内容，并保存写入流中
                fos.write(b, 0, hasRead);
            }

            System.out.println("提示：读取复制完成...");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
