import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-23
 * Time: 22:08
 */
public class Demo6 {
    public static void main(String[] args) {

        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")){
            // 已知文件是二进制文件  写入时需要通过字节流对象进行写入 但是不方便  转化为通过字符写入
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("i love you");
            printWriter.flush();// 冲刷缓冲区  将缓冲区中的内容冲刷到硬盘之中
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
