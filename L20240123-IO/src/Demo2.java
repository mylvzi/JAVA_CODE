import java.io.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-23
 * Time: 19:38
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {

        // 设置为true  表示在原有内容上进行追加
        try (Writer writer = new FileWriter("d:/test.txt",true)){
            // 将test中的内容更改为"hello"
            writer.write("hello");
        }

//        try (Reader reader = new FileReader("d:/test.txt")) {
//            char[] cbuf = new char[13];// 参数表示cbuf一次最多读取的字符个数
//            while (true) {
//                int c = reader.read(cbuf);
//                if (c == -1) break;
//                System.out.println(Arrays.toString(cbuf));
//            }
//        }


//        while (true) {
//            int ret = reader.read();
//            if(ret == -1) {
//                System.out.println("文件读取完毕");
//                break;
//            }
//            char c = (char) ret;
//            System.out.println(c);
//        }
    }
}
