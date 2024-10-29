package com.gyd.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {

public static Connection getConnection() {

    Connection conn=null;
    try {
        //创建一个配置文件对象
        Properties prop = new Properties();
        //加载文件
        prop.load(new FileInputStream("jdbc01/resources/db.properties"));
        //从加载文件获取对应值
        String driver = prop.getProperty("mysql.driver");
        String url = prop.getProperty("mysql.url");
        String user = prop.getProperty("mysql.user");
        String password = prop.getProperty("mysql.password");

        Class.forName(driver);
        conn= DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException | SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return conn;


}

}
