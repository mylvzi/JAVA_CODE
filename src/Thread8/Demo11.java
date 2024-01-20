package Thread8;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:使用Semophore实现定量线程执行任务
 * User: 绿字
 * Date: 2024-01-16
 * Time: 20:18
 */
public class Demo11 {
    public static void main(String[] args) {
        // 限制最多可以并发编程的线程数目为2
        final int MAX_CONCURRENT_TASKS = 2;

        // 创建可用资源为2的信号量
        Semaphore semaphore = new Semaphore(2);

        // 线程执行任务
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;

            // 启动线程 执行任务
            Thread t = new Thread(() -> {
                try {
                    // 先打印获取信号量的线程id
                    System.out.println("线程 " + taskId + "正在获取信号量");

                    // 可用资源数目减1  如果为0 线程就阻塞等待
                    semaphore.acquire();
                    System.out.println("线程 " + taskId + "已经获取到信号量");

                    // 规定任务的执行时间
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    // 任务执行完毕  释放信号量
                    semaphore.release();
                    System.out.println("线程 " + taskId + "执行完毕,可用资源加1");
                }
            });

            t.start();
        }
    }
}
