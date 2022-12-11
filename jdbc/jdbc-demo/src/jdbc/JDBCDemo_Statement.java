package jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo_Statement {
    /*
     * 执行DML
     * */
    @Test
    public void testDML() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "update account set money=1000 where id=1";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);//执行DML语句后是受影响的行数
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        stmt.close();
        conn.close();
    }

    @Test
    public void testDDL() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "drop database if exists db2";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);//执行DML语句后是受影响的行数,结果可能是0，不能用判断，不报异常就ok
//        if (count > 0) {
//            System.out.println("修改成功");
//        } else {
//            System.out.println("修改失败");
//        }

        stmt.close();
        conn.close();
    }
}

