package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-19
 * Time: 13:52
 */
public class Demo17 {
    // 将标志位设置为类变量
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!isQuit) {
                System.out.println("Thread is working");
            }
        });

        t.start();

        // 五秒后改变标志位
        Thread.sleep(2000);
        isQuit = true;

    }
}
