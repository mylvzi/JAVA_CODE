import java.io.File;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-25
 * Time: 21:55
 */
public class Demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1.用户输入要扫描的指定目录
        System.out.println("请输入你要扫描的指定目录: ");
        String path = scanner.next();
        File rootPath = new File(path);

        if(!rootPath.isDirectory()) {// 用户输入的目录不合法
            System.out.println("您输入的指定目录不合法!");
            return;
        }

        // 2.输入要查询的关键词
        System.out.println("请输入要查询的关键词: ");
        String word = scanner.next();

        // 3.进行扫描  也可以使用此方法进行递归操作
        scanDir(rootPath,word);

    }

    private static void scanDir(File rootPath, String word) {

        // 1.列出扫描目录下所包含的所有文件 此方法会返回File类型,操作会更加简便(可以利用File类中的所有数据)
        File[] files = rootPath.listFiles();
        if(files == null) {
            return;// 扫描目录为空  直接返回
        }

        // 依次扫描每个目录
        for(File f : files) {
            // 加个日志 方便观察递归扫描的过程
            System.out.println("正在扫描: " + f.getAbsolutePath());
            if(f.isFile()) {
                // 普通文件 -->判断是否包含查询的关键词
                checkFileContainsWord(f,word);

            }else {
                // 目录  递归扫描其子文件
                scanDir(f,word);
            }
        }
    }

    private static void checkFileContainsWord(File f, String word) {
        if(!f.getName().contains(word)) {
            return;// 不包含要删除的关键词
        }

        // 包含要删除的关键词  打印日志 并询问用户是否需要进行删除
        System.out.println("正在扫描的文件为: " + f.getName() + ",是否要删除该文件?(Y/N)");
        Scanner scanner = new Scanner(System.in);
        String ret = scanner.next();

        if(ret.equals("Y") || ret.equals("y")) {
            // 执行删除操作
            f.delete();
            System.out.println("删除" + f.getAbsolutePath() + "成功");
        }else {
            // 不执行删除操作
            return;
        }
    }

}
