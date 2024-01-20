package Thread6;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:定时器的模拟实现
 * User: 绿字
 * Date: 2023-12-26
 * Time: 20:11
 */

class MyTimerTask implements Comparable<MyTimerTask>{
    // 有两个参数  执行任务  执行时间
    private Runnable runnable;// 要执行的任务
    private long time;// 执行任务的时间  此处的时间是绝对时间

    // 第二个参数delay是schedule方法传入的  而我们实际要执行任务的时间保存为绝对时间
    public MyTimerTask(Runnable runnable,long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    // 重写compareTo方法  设置为time小的先执行
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
    }

    // 设置获取方法
    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }
}

class MyTimer {
    // 使用优先级队列管理数据  队列的元素是任务类
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    // 因为调用schedule的线程和本身的扫描线程都会对queue进行修改
    // 所以存在线程安全问题  要加锁
    // 创建用于加锁的对象
    private Object locker = new Object();

    // 提供schedule方法
    public void schedule(Runnable runnable,long delay) {
        synchronized (locker) {
            // 所以 schedule方法的作用就是将一个任务转化为队列的一个元素
            queue.offer(new MyTimerTask(runnable,delay));
            locker.notify();// 进行唤醒
            // 此处的唤醒两处的wait
            // 一是为空 需要新元素添加进来  此处需要wait
            // 二是距离最快执行任务还有一定的时间  为了减少cpu资源的开销与调度 需要扫描线程进行阻塞等待
        }
    }

    // 扫描线程属于定时器类
    public MyTimer() {
        // MyTimer类的扫描线程  用于管理要执行的任务
        Thread t = new Thread(() -> {
            // 因为要不断的进行扫描 判断是否要执行对应的任务  此处应使用循环
            while(true) {
                try {
                    synchronized(locker) {
                        // 队列为空  没有要执行的任务  阻塞等待  使用wait方法
                        // 等到有新的元素添加进队列之后再唤醒
                        // 所以在schedule方法中进行唤醒
                        // 此处也不能使用sleep方法进行阻塞等待  因为在等待的过程中可能添加新的任务
                        // 新的任务的执行时间有可能比当前队首元素的执行时间更早  要更换执行顺序
                        while(queue.isEmpty()) {
                            locker.wait();
                        }

                        // 不为空  取出队首元素 并判断是否需要执行
                        MyTimerTask task= queue.peek();
                        long curTime = System.currentTimeMillis();
                        if(curTime >= task.getTime()) {
                            // 达到要执行任务的时间  执行任务
                            task.getRunnable().run();
                            // 执行完毕之后需要将此任务从队列中删除
                            queue.poll();
                        }else {
                            // 走到这里代表还未到执行任务的时间
                            // 如果不等待 则会一直进行while循环  会占用cpu资源
                            // 所以这里可以让扫描线程阻塞等待 一直等待到最短的任务执行时间到了
                            locker.wait(task.getTime() - curTime );
                        }
                    }

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        t.start();
    }
}
public class Demo2 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);
        System.out.println("程序开始执行");
    }
}
