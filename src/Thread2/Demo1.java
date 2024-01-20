package Thread2;

/**
 * Created with IntelliJ IDEA.
 * Description:synchronized修饰方法
 * User: 绿字
 * Date: 2023-12-21
 * Time: 20:52
 */

class Counter {
    public static int cnt;

    // 以下两种写法等价
    synchronized public void increment() {
        cnt++;
    }

    public void increment2() {
        synchronized (this) {
            cnt++;
        }
    }

    // 类方法
    synchronized public static void increment3() {
        cnt++;
    }

    public static void increment4() {
        // 这里利用到了反射
        synchronized (Counter.class) {
            cnt++;
        }
    }



}
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.cnt);
    }
}
