package Thread8;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-16
 * Time: 21:23
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        // 等待的线程数为3
        int numberOfTasks = 3;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);
        for (int i = 0; i < numberOfTasks; i++) {
            Thread t = new Thread(() ->{
                System.out.println(Thread.currentThread().getId() + "正在工作!");

                // 每完成一个任务就减1
                latch.countDown();
            });

            t.start();
        }

        // 主线程等待所有的线程执行完毕
        latch.await();
        System.out.println("所有线程都执行完毕");
    }
}
