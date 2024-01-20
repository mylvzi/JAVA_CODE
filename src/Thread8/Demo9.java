package Thread8;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:通过Reentrant实现公平锁
 * User: 绿字
 * Date: 2024-01-16
 * Time: 17:11
 */
public class Demo9 {
    // 设置为true 表示是一个公平锁
    public static ReentrantLock lock = new ReentrantLock(true);

    // 定义要执行的任务
    static class Worker implements  Runnable {
        // 用于标识线程id
        public int id;

        // 构造方法
        public Worker(int id) {
            this.id = id;
        }

        // 规定要执行的任务
        @Override
        public void run() {
            System.out.println("线程: " + id + "正在尝试获取锁");
            lock.lock();
            try {
                System.out.println("线程: " + id + "已经获取到锁");
            }finally {
                // 解锁
                lock.unlock();
                System.out.println("线程: " + id + "释放锁");
            }
        }
    }
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Worker(i));
            t.start();
        }
    }
}
