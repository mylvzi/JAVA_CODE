package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-06
 * Time: 21:36
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        // 利用匿名内部类直接实例化一个Thread类  接口时Runable
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        t.start();
        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
