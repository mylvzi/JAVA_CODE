import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-23
 * Time: 21:49
 */
public class Demo4 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt",true)){
            String s = "你好世界";
            outputStream.write(s.getBytes());// 将字符串s转化为对应的编码写入到文件之中
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
