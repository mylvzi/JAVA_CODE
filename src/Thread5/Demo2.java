package Thread5;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:阻塞队列实现的四个类
 * User: 绿字
 * Date: 2023-12-30
 * Time: 11:19
 */
public class Demo2 {
    public static void main(String[] args) {

        BlockingQueue queue1 = new ArrayBlockingQueue(2);

        BlockingQueue queue2 = new LinkedBlockingQueue();
        BlockingQueue queue3 = new PriorityBlockingQueue();

        BlockingQueue<String> queue4 = new SynchronousQueue<String>();

        BlockingQueue queue5 = new DelayQueue();

        Thread t1 = new Thread(() -> {
            String data = "hello !";
            System.out.println("生产者生产" + data);
            try {
                queue4.put(data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                String ret = queue4.take();
                System.out.println("消费者消费" + ret);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();



    }
}
