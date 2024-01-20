package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-15
 * Time: 10:59
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        // 使用lambda表达式
        Runnable runnable = () -> {
            while (true) {
                System.out.println("Mythread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        while (true) {
            System.out.println("main");
            Thread.sleep(1000);
        }
    }
}
