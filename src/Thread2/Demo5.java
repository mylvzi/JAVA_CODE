package Thread2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-25
 * Time: 11:11
 */
public class Demo5 {
    // 设计一个标志位
    private static int isQuit = 0;
    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            while(isQuit == 0) {
                // 让线程休眠一会儿
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // ......
            }
            System.out.println("t1线程结束");
        });

// 在t2线程中修改isQuit的值
        Thread t2 = new Thread(() -> {
            System.out.println("请输入isQuit的值：");
            Scanner scan = new Scanner(System.in);
            isQuit = scan.nextInt();
        });

        t1.start();
        t2.start();
    }
}
