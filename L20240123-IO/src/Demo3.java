import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-23
 * Time: 21:41
 */
public class Demo3 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")){
            byte[] buffer = new byte[1024];
            int n = inputStream.read(buffer);
            System.out.println("n = " + n);
            for (int i = 0; i < n; i++) {
                System.out.printf("%x\n",buffer[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
