package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-07
 * Time: 11:05
 */
public class Demo6 {
    // 使用lambda表达式+runnable接口  可以降低代码的耦合性
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while(true) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };

        Thread t = new Thread(runnable);
        t.start();
        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
