import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-30
 * Time: 11:56
 */
public class Demo {
    public static void main(String[] args) throws SQLException {

        // 1.准备数据源  实例化对象 建立URL  设置用户名和密码
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");


        // 2.和数据库服务器建立连接  连接好了之后才能进行后序的  "请求--响应" 操作
        Connection connection = dataSource.getConnection();// 此处会报错  需要抛出异常 直接使用throws进行抛出

//        // 3.构造sql  sql语句最后不需要再去添加;  命令行的时候添加;
//        String sql1 = "insert into student values(1,'张三')";
//        PreparedStatement statement = connection.prepareStatement(sql1);

        // 将id为3的人的名字设置为王五
        String sql2 = "update student set name = '王五' where id = 1";
        PreparedStatement statement2 = connection.prepareStatement(sql2);

        // 4. 将sql发送给服务器 执行sql
//        int n = statement.executeUpdate();
//        System.out.println(n);

        int n2 = statement2.executeUpdate();
        System.out.println(n2);


        // 5.释放资源  注意释放顺序  先获取的后释放
        statement2.close();
        connection.close();

    }
}
