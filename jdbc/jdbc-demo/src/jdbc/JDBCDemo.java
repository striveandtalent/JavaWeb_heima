package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "update account set money=20 where id=1";
        Statement stmt = conn.createStatement();
        boolean count = stmt.execute(sql);
        System.out.println(count);
        stmt.close();
        conn.close();


    }
}
