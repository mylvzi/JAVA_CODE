package Thread7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:模拟实现线程池
 * User: 绿字
 * Date: 2023-12-31
 * Time: 10:55
 */

class MyThreadPool {
    // 创建一个任务队列  用于存放线程池要执行的任务  10代表次任务队列最多存放的任务数量是10  超过10就要阻塞等待
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);

    // 创建提交方法  将任务提交到任务队列之中
    public void submit(Runnable runnable) throws InterruptedException {
        // 此处采用的拒绝策略就是使用阻塞队列  队列满 阻塞等待
        queue.put(runnable);
    }

    // 创建构造方法
    public MyThreadPool(int n) {
        // 创建n个线程  就相当于newFixedPool的效果 创建出制定容量的线程池
        for (int i = 0; i < n; i++) {
            // 线程池中的线程是要执行任务的  获取任务队列中的任务 执行
            Thread t = new Thread(() -> {
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            t.start();
        }

    }
}
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int id = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程执行id" + id);
                }
            });
        }
    }
}
