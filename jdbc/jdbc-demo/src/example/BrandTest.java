package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import pojo.Brand;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增删改查操作
 */
public class BrandTest {
    @Test
    /**
     *
     * */
    public void testSelectAll() throws Exception {
       /* Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);*/

        //使用Druid获取连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Brand> list = new ArrayList<>();
        Brand brand = new Brand();
        while (rs.next()) {

            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
            System.out.println(brand);
        }
        rs.close();
        pstmt.close();
        conn.close();
    }


    @Test
    public void testAdd() throws Exception {
        //模拟接收页面提交的参数信息
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)";
        //获取执行对象
        PreparedStatement pstmt = conn.prepareStatement((sql));
        //设置sql参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        //执行sql
        int count = pstmt.executeUpdate();//影响的行数
        //处理结果
        System.out.println(count > 0);
        /*boolean result = (count > 0);
        if (result=true){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }*/
        pstmt.close();
        conn.close();
    }


    @Test
    public void testUpdate() throws Exception {
        //模拟用户修改的数据
        String brandName = "香不飘";
        String companyName = "香不飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;
        int id = 8;
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        String sql = "update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, 8);

        //执行sql
        int count = pstmt.executeUpdate();
        System.out.println(count > 0);

    }

}
