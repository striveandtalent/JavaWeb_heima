package jdbc;

import org.junit.jupiter.api.Test;
import pojo.Account;
import sun.security.util.Password;

import javax.naming.Name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo_UserLogin {

    /*
     * 用户登录
     * */
    @Test
    public void login() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入的 用户名和密码
        String name = "zhangsan";
        String pwd = "123456";

        String sql = "select * from tb_user where username='" + name + "'and password='" + pwd + "'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登录失败！");
        }

        rs.close();
        stmt.close();
        conn.close();
    }


    /*
     * 演示SQL注入
     * */
    @Test
    public void login_inject() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入的 用户名和密码
        String name = "asd";
        String pwd = "'or'1'='1";

        String sql = "select * from tb_user where username='" + name + "'and password='" + pwd + "'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登录失败！");
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}

