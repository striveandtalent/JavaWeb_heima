package jdbc;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import pojo.Test_user;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class test20221211 {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
//        String username = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, username, password);

        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        String sql = "select * from user";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Test_user test_user = new Test_user();
        List<Test_user> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String uname = rs.getString("username");
            String pwd = rs.getString("password");
            String name = rs.getString("name");
            String sex = rs.getString("sex");

            test_user.setId(id);
            test_user.setUsername(uname);
            test_user.setPassword(pwd);
            test_user.setName(name);
            test_user.setSex(sex);
            list.add(test_user);

        }

        System.out.println(list);
    }
}
