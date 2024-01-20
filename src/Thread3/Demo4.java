package Thread3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-25
 * Time: 13:15
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (locker) {
                System.out.println("使用notify 进行唤醒");
                locker.notify();
            }
        });

        t1.start();

        synchronized (locker) {
            System.out.println("wait 开始");
            locker.wait();
            System.out.println("wait 结束");
        }

    }
}
