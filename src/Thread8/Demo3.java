package Thread8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:使用CAS解决线程安全问题  使用AtomicInteger来避免穿插执行的操作
 * User: 绿字
 * Date: 2024-01-10
 * Time: 21:34
 */
public class Demo3 {
    // 这里有一个小细节  必须要实例化一个AtomicInteger对象
    // 常规的成员类模式是0  但是此处是利用了外部类  是一个引用  如果不实例化就会产生空指针异常
    private static AtomicInteger cnt = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // 等价于cnt++;
                cnt.getAndIncrement();
                // 等价与cnt--
//                cnt.getAndDecrement();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                cnt.getAndIncrement();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(cnt);
    }
}
