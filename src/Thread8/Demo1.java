package Thread8;

/**
 * Created with IntelliJ IDEA.
 * Description:多个线程针对同一个变量进行修改会产生线程安全问题  解决方式有两个  加锁  CAS
 * User: 绿字
 * Date: 2024-01-10
 * Time: 21:23
 */
public class Demo1 {
    private static int cnt;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                cnt++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                cnt++;
            }
        });

        t1.start();
        t2.start();

        // 让主线程等待两个线程都执行完毕
        t1.join();
        t2.join();

        System.out.println(cnt);
    }
}
