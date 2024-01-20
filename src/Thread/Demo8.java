package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-07
 * Time: 11:48
 */
public class Demo8 {
    // 这两个线程是并发执行的 打印谁其实是一个随机事件
    // isAlive  判断线程是否结束
    // 我们通过Thread类来实现线程 但是Thread类和线程的生命周期其实是不同的  Thread类的生命周期高于线程
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程结束");
        });

        // 如果在这个地方打印  输出false  因为线程还没有创建呢
//        System.out.println(t.isAlive());

        t.start();
        System.out.println(t.isAlive());
        Thread.sleep(3000);
        System.out.println(t.isAlive());

    }
}
