package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql1 = "update account set money=200 where id=1";
        String sql2 = "update account set money=300 where id=2";
        Statement stmt = conn.createStatement();


        try {
            //开启事务
            conn.setAutoCommit(false);
            boolean count1 = stmt.execute(sql1);
            System.out.println(count1);

            boolean count2 = stmt.execute(sql2);
            System.out.println(count2);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        stmt.close();
        conn.close();


    }
}
