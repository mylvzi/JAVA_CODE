package Thread6;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:定时器的模拟实现1
 * User: 绿字
 * Date: 2023-12-28
 * Time: 22:54
 */

class MyTimerTask2 implements Comparable<MyTimerTask2>{
    private Runnable runnable;
    private long time;// 绝对时间

    public MyTimerTask2(Runnable runnable,long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTimerTask2 o) {
        return (int) (this.time - o.time);
    }
}

class MyTimer2 {
    private PriorityQueue<MyTimerTask2> queue = new PriorityQueue<>();

    private Object locker = new Object();

    public void schedule(Runnable runnable,long delay) throws InterruptedException {
        synchronized (locker) {
            queue.offer(new MyTimerTask2(runnable,delay));
            locker.wait();
        }

    }
    // 扫描线程
    public MyTimer2() {
        Thread t = new Thread(() -> {
            while (true) {
                synchronized (locker){
                    try {
                        while (queue.isEmpty()) {
                            locker.wait();
                        }

                        // 非空
                        MyTimerTask2 task2 = queue.peek();
                        long curTime = System.currentTimeMillis();

                        if (curTime >= task2.getTime()) {
                            task2.getRunnable().run();
                            queue.poll();
                        }else {
                            locker.wait(curTime - System.currentTimeMillis());
                        }

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                }
        });

        t.start();
    }
}







public class Demo3 {
    public static void main(String[] args) {
        System.out.println("This is a liushuangqi");


    // 这是一个很好的注释场景
        System.out.println("hello xiaoming");


        Scanner scanner = new Scanner(System.in);
        // 这是一个非常好的实用工具

        // 金色光标  大写锁定
        // 红色光标  中文输入
        // 正常光标  编码区域



    }
}
