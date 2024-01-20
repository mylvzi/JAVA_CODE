package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-15
 * Time: 10:55
 */
public class Demo11 {
    public static void main(String[] args) {
        // 实现Runnable  重写run  使用匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
