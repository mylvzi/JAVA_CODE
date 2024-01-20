package Thread5;

/**
 * Created with IntelliJ IDEA.
 * Description:阻塞队列的模拟实现
 * User: 绿字
 * Date: 2023-12-26
 * Time: 9:49
 */

class MyBlockingQueue {
    // 这里使用数组实现  且存储为String类型
    private String[] elem = new String[100];

    private volatile int front;// 队首元素
    private volatile int rear;// 队尾元素
    private volatile int cnt;// 计数器

    // 用于加锁的对象
    private Object locker = new Object();

//    // 提供两个核心方法 入队列 和 出队列
//    public void put(String data) throws InterruptedException {
//        synchronized (locker) {
//            // 先判满 如果满了就要阻塞
//            while (cnt == this.elem.length) {
//                // 满了 就让线程阻塞 直到有其他线程调用了take 使队列不为满
//                locker.wait();
//                // wait被唤醒之后 还要去判断当前数组是否为满
//                // 因为wait被唤醒的方式有两种  notify 和 interrupt抛出异常唤醒
//            }
//
//            // 队列没满  添加数据
//            this.elem[rear] = data;
//            rear = (rear+1) % elem.length;
//            cnt++;
//
//            // 这里的notify用于唤醒take方法中的wait
//            locker.notify();
//        }
//
//    }

    // put 向阻塞队列中存入数据
    public void put(String data) throws InterruptedException {
        synchronized(locker) {
            // 如果为满 就要阻塞等待
            // 此处要使用while循环
            while(cnt == elem.length) {
                // 使用wait进行等待	wait必须搭配synchronized进行使用
                // 直到队列中有元素被take出去 才能进行唤醒
                locker.wait();
                // 被唤醒之后还要再次判断当前队列是否为满
            }

            // 不为空 在队尾存入数据
            this.elem[rear] = data;
            rear = (rear+1) % elem.length;
            cnt++;
            locker.notify();// 用于唤醒take方法中的wait操作
        }
    }

//    public String take() throws InterruptedException {
//        synchronized (locker) {
//            // 先判空 如果为空 就不能再出队列直接阻塞
//            while (cnt == 0) {
//                // 空 让线程阻塞  直到其他线程调用put使队列不为空
//                locker.wait();
//            }
//
//            // 队列不为空  拿出队首元素即可
//            String ret = this.elem[front];
//            front = (front+1) % elem.length;
//            cnt--;
//
//            // 这里用于唤醒put方法中的wait
//            locker.notify();
//            return ret;
//        }
//    }

    // take 从队列中获取对应的数据
    public String take() throws InterruptedException {
        synchronized(locker) {
            // 如果为空就阻塞等待  直到有新的元素进入到队列之中
            while(cnt == 0) {
                // 使用wait进行阻塞等待
                // 当有新的元素被添加进入到队列后 就唤醒
                locker.wait();
                // 被唤醒之后还要再次判断当前队列是否为空
            }
            // 不为空 取出数据
            String ret = this.elem[front];
            front = (front+1) % elem.length;
            cnt--;
            locker.notify();// 用于唤醒put方法内部的wait操作
            return ret;
        }
    }
}
public class Thread5 {
    public static void main(String[] args) {
        // 使用上述阻塞队列实现生产者消费者模型
        MyBlockingQueue queue = new MyBlockingQueue();

        // 生产者模型
        Thread t1 = new Thread(() -> {
            int num = 1;
            while (true) {
                try {
                    queue.put(num+"");
                    System.out.println("生产者生产:" + num);
                    num++;


//                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 消费者模型
        Thread t2 = new Thread(() ->{
            while (true) {
                try {
                    String ret = queue.take();
                    System.out.println("消费者消费:" + ret);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
