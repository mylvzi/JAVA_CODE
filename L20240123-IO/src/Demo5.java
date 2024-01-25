import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-23
 * Time: 22:01
 */
public class Demo5 {
    public static void main(String[] args) {

        // 已知文件是二进制文件  读取需要通过字节流进行读取  打印时通过字符打印
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {

            // 将inputStream作为参数传入  表示scanner对象即将从这个文件中进行读取
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext()) {
                String s = scanner.next();
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;

    }
}
