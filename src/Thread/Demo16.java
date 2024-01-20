package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-19
 * Time: 11:16
 */
public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        System.out.println(t.getState());// Thread类存在，但是还没有调用start方法，状态为NEW
        t.start();
        System.out.println(t.getState());// RUNNABLE
        Thread.sleep(3000);
        System.out.println(t.getState());// TERMINATED
    }
}
