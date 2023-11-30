import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-30
 * Time: 17:49
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的id");
        int id = scanner.nextInt();
        System.out.println("请输入你的名字");
        String name = scanner.next();


        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        // 此处注意选择正确的方法
        Connection connection = dataSource.getConnection();

        // 构造sql  参数使用通配符  ?  表示可以接受任意类型的参数
        String sql = "insert into student values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);

       int n =  statement.executeUpdate();
        System.out.println(n);

        statement.close();
        connection.close();
    }
}
