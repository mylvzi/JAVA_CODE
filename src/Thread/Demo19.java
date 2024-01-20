package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-20
 * Time: 10:20
 */
public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Thread t= new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程工作中！");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t.start();
        System.out.println("线程开启");
        t.join(1000);// 让主线程等待t线程
        System.out.println("线程结束");
    }
}
