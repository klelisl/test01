package com.gyd.test;

import java.io.*;

public class BufferedWriterDemo {
    public static void main(String[] args) {

        System.out.println("请输入写入文件内容");

        try {

            //创建一个字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //创建一个写入文件对象
            BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\abc\\a.txt"));

            //循环判断多次,判断何时停止输入(结束)
            String line=null;
            while(!((line=br.readLine()).equals("exit"))){

                //将内容写入文件中
                bw.write(line);
                //换行
                bw.newLine();
            }

            //刷新缓冲区
            bw.flush();

            //关闭
            bw.close();
            System.out.println("提示:写入文件内容完成....");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
