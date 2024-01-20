package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-06
 * Time: 21:21
 */

//创建一个类  继承于Thread类
class MyThread extends Thread {
    @Override
    public void run() {
        // 线程的入口  告诉线程要执行哪些逻辑

            System.out.println("hello thread");
            try {
                // 休眠1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // 首先要实例化出一个Thread类
        Thread thread = new MyThread();
//         start和run都是Thread类的成员
//         run只是告诉线程要去执行那些逻辑
//         start是真正的调用系统的api，创建出一个线程，再让线程去执行run
        thread.start();
//        thread.run();
        while (true) {
            System.out.println("hello main");
            // 休眠1s
            Thread.sleep(1000);
        }
    }
}
