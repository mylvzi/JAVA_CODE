package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-19
 * Time: 9:45
 */
public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
//        // 获取线程的所有状态
//        for (Thread.State state : Thread.State.values()) {
//            System.out.print(state+" ");
//        }
        Thread t = new Thread(() -> {
            while (true) {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("hello thread");
            }
        });

        // 在线程开启前将其设置为后台线程
        t.setDaemon(true);
        t.start();
        System.out.println("主线程开启");
        Thread.sleep(3000);
    }
}
