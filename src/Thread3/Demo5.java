package Thread3;

/**
 * Created with IntelliJ IDEA.
 * Description:使用两个线程模拟使用notify的使用
 * User: 绿字
 * Date: 2023-12-25
 * Time: 14:14
 */
public class Demo5 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(() ->{
            synchronized (locker) {
                System.out.println("wait 开始");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("wait 结束");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (locker) {
                System.out.println("使用notify 方法 进行唤醒");
                locker.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
