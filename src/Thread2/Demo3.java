package Thread2;

/**
 * Created with IntelliJ IDEA.
 * Description:死锁的第二种情况：两个线程，分别获取对方的锁 造成死锁
 * User: 绿字
 * Date: 2023-12-21
 * Time: 21:30
 */

/**
 * 必须是两个锁此时都同时拥有一个锁的情况下(还未对当前锁解锁)
 * 在交叉去访问对方的锁时  才会发生锁冲突
 */
public class Demo3 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    // sleep非常关键  必须先让两个线程都拥有一把锁，再去交叉加锁  这样才会发生死锁
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // t1此时已经拥有一个锁了  让他再去给另一个对象上锁  必须是嵌套关系  这样才会发生锁冲突
                synchronized (locker2) {
                    System.out.println("t1 加锁locker2成功！");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (locker1) {
                    System.out.println("t2 加锁locker1 成功!");
                }
            }
        });

        t1.start();
        t2.start();

    }
}
