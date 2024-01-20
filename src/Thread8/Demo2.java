package Thread8;

/**
 * Created with IntelliJ IDEA.
 * Description:利用加锁解决线程安全问题
 * User: 绿字
 * Date: 2024-01-10
 * Time: 21:30
 */
public class Demo2 {
    // 设置一个加锁的对象
    private static Object locker = new Object();
    private static int cnt;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                for (int i = 0; i < 5000; i++) {
                    cnt++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                for (int i = 0; i < 5000; i++) {
                    cnt++;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(cnt);

    }
}
