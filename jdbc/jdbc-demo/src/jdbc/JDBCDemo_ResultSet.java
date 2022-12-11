package jdbc;

import org.junit.jupiter.api.Test;
import pojo.Account;

import javax.naming.Name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo_ResultSet {
    /*
     * 执行DQL
     * */
    @Test
    public void testResultSet() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select * from account";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        //处理结果，遍历rs中的所有数据
//        while (rs.next()) {
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            Double money = rs.getDouble(3);
//            System.out.println("id："+id);
//            System.out.println("姓名："+name);
//            System.out.println("money:"+money);
//            System.out.println("==============");
//        }
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Double money = rs.getDouble("money");
            System.out.println("id：" + id);
            System.out.println("姓名：" + name);
            System.out.println("money:" + money);
            System.out.println("==============");
        }
        rs.close();
        stmt.close();
        conn.close();
    }


    /*
     * 查询account数据，封装为account对象中，并且存储到ArrayList集合中
     * 1.定义实体类Account
     * 2.查询数据，并且封装到account对象中
     * 3.将account对象存入arrayList对象中
     * */
    @Test
    public void testResultSet2() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select * from account";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Account> list = new ArrayList<>();
        while (rs.next()) {
            Account account = new Account();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Double money = rs.getDouble("money");
            //给account赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            //存入集合
            list.add(account);
        }
        System.out.println(list);
        rs.close();
        stmt.close();
        conn.close();
    }

}

