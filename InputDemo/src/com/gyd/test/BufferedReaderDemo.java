package com.gyd.test;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        try {
            //创建一个读取文件对象
            File f1=new File("e:\\abc\\a.txt");

            //创建一个字节流对象
            BufferedReader br=new BufferedReader(new FileReader(f1));

            //readline()方法用于从缓冲区每次读取一行,ready()用于判断文件是否被读取完毕
            while (br.ready()){

                //获取读取内容
                sb.append(br.readLine());

            }
            System.out.println(sb);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
