package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-07
 * Time: 10:28
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        // 继承Thread  使用匿名内部类
        Thread t = new Thread() {
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
        };

        t.start();
        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
