package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-19
 * Time: 9:33
 */
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程结束");
        });



//        System.out.println(t.isAlive());// 输出false
//
//        // 开启线程
//        t.start();
//        System.out.println(t.isAlive());// 输出true
//        Thread.sleep(3000);
//        System.out.println(t.isAlive());// 输出false
    }
}
