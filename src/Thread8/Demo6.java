package Thread8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:模拟实现一个公平锁
 * Dem07中有不使用公平锁的例子
 * User: 绿字
 * Date: 2024-01-12
 * Time: 15:31
 */
public class Demo6 {
    private static Object locker = new Object();
    public static void main(String[] args) throws InterruptedException {
        // 创建一个等待队列 用于确定线程之间的执行顺序
        BlockingQueue<Thread> blockingQueue = new SynchronousQueue<>();

        // 创建一个锁 先让其拥有锁对象
        Thread t = new Thread(() ->{
            synchronized (locker) {
                System.out.println("this is initial thread");
            }
        });

        // 创建三个线程  分别执行相应的任务
        Thread t1 =  new Thread(() -> {
            synchronized (locker) {
                System.out.println("this is t1");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("this is t2");
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("this is t3");
            }
        });

        t.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
