package Thread8;

/**
 * Created with IntelliJ IDEA.
 * Description:和Demo4属于同一个知识
 * User: 绿字
 * Date: 2024-01-12
 * Time: 13:10
 */
public class Demo5 {


    // 使用Runnable解决
    private static int sum;
    private static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            synchronized (locker) {
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }

                // 任务执行完毕  唤醒加锁的线程
                locker.notify();
            }
        });

        t.start();

        synchronized (locker) {
            while (sum == 0) {
                // 等待线程执行解锁
                locker.wait();
            }
        }
        System.out.println(sum);
    }
}
