package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:线程安全问题
 * User: 绿字
 * Date: 2023-12-20
 * Time: 14:40
 */
public class Demo21 {
    private static int cnt = 0;
    public static void main(String[] args) throws InterruptedException {
        // 锁竞争的对象
        Object locker = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized(locker) {
                    cnt++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // 此时两个线程针对的是不同的对象进行加锁  不发生锁冲突
                synchronized(locker2) {
                    cnt++;
                }
            }
        });

        // 线程开启
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        // 让主线程等待两个线程结束



        // 输出打印
        System.out.println(cnt);// 输出10000








//        int cnt = 0;
//        for (int i = 0; i < 10000; i++) {
//            cnt++;
//        }
//
//        System.out.println(cnt);// 输出10000
    }
}
