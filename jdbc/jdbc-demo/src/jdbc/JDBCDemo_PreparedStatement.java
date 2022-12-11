package jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCDemo_PreparedStatement {

    /*
     * 用户登录
     * */
    @Test
    public void loginPreparedStatement() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入的 用户名和密码
        String name = "zhangsan";
        String pwd = "123";
        String sql = "select  * from tb_user where username=? and password=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);
        ResultSet rs = pstmt.executeQuery();
        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登录失败！");
        }
        rs.close();
        pstmt.close();
        conn.close();
    }


}

