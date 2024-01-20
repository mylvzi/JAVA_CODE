package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-07
 * Time: 11:28
 */
public class Demo7 {
    public static void main(String[] args) {
        // 可以为线程起一个名字作为标识  对线程的执行没有影响  就是单纯的一个"标识"  方便之后调试进行检查区分
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"这是一个线程名字");

        // 在start之前将线程设置为后台线程 主线程一结束 整个进程就结束
        // 线程默认是前台线程  前台线程不结束 整个进程就不可能结束
        t.setDaemon(true);
        t.start();
        // 什么也不打印  t.start在一瞬间就执行完了(主线程一瞬间就执行完了)  此时没有其他前台线程  直接结束   另一个线程来不及执行了
    }
}
