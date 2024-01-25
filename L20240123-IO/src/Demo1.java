import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-23
 * Time: 12:18
 */
public class Demo1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 改名  将java改为java2
        File file1 = new File("d:/java");
        File file2 = new File("d:/java2");
        boolean ret = file1.renameTo(file2);
        System.out.println(ret);
//        // 创建目录  创建成功返回true
//        File file = new File("d:/java");
//        boolean ret = file.mkdir();
//        System.out.println(ret);
//
//        // 连续创建目录(即使中间目录不存在)
//        File file2 = new File("d:/python/aaa/bbb/ccc");
//        boolean ret2 = file2.mkdirs();
//        System.out.println(ret2);
//        // 根据File对象 列出包含目录(以字符串表示)并打印
//        File file = new File("d:/");
//        String[] ret = file.list();// 以字符串数组的形式返回
//        System.out.println(Arrays.toString(ret));// 打印
//
//        // 根据File对象  列出包含目录(以File对象的形式返回)
//        File[] ret2 = file.listFiles();//
//        System.out.println(Arrays.toString(ret2));

//        file.mkdir();

//        // 创建File对象
//        File file = new File("d:/test.txt");
//
//        // 1.返回父目录的文件路径  输出d:\
//        System.out.println(file.getParent());
//
//        // 2.返回文件名  文件名 = 前缀 + 扩展名
//        System.out.println(file.getName());
//
//        // 3.获取文件路径
//        System.out.println(file.getPath());// 相对路径
//        System.out.println(file.getAbsolutePath());// 绝对路径(相对路径 拼接上 前面的路径)
//        System.out.println(file.getCanonicalPath());// 对绝对路径的简化处理
//
//        // 4.
//        System.out.println(file.exists());// 判断文件是否存在  true
//        System.out.println(file.isDirectory());// 判断文件是否是一个目录  false
//        System.out.println(file.isFile());// 判断是否是一个普通文件  true
//
//        System.out.println(file.createNewFile());// 根据file对象创建一个空文件 创建成功返回false
//        System.out.println(file.delete());// 删除file对象的文件  此时d盘中的test.txt被删除 删除成功返回true
//
//         // 5.在进程结束之后再执行删除操作
//        file.deleteOnExit();
//        Thread.sleep(5000);
//        System.out.println("进程结束!");

    }

////    // 字符串类型路径分隔符 "/"  "\"
////    public static final String pathSeparator
//
//    //
//    private File(String child, File parent) {
//    }
//
//    public File(String pathname) {
//    }
//
//    public File(String parent, String child) {
//    }
}
