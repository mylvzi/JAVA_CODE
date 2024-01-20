package Thread5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:阻塞队列的使用
 * User: 绿字
 * Date: 2023-12-28
 * Time: 11:23
 */
public class Demo1 {
    public static void main(String[] args) {
//        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(10);
//        BlockingQueue<Integer> queue2 = new LinkedBlockingQueue<>(10);

        // 创建一个阻塞队列
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // 生产者线程
        Thread producer = new Thread(() ->{
                try {
                    for (int i = 0; i < 5; i++) {
                        queue.put(i);
                        System.out.println("produce:" + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });

        // 消费者模型
        Thread consumer = new Thread(() ->{
            try {
                for (int i = 0; i < 5; i++) {
                    Integer ret = queue.take();
                    System.out.println("consume:" + ret);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // 开启两个线程
        producer.start();
        consumer.start();
    }
}
