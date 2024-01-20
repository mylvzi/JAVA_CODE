package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-17
 * Time: 20:42
 */
public class Demo13 {
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


















        // 源码规定   默认是前台线程
        /* Whether or not the thread is a daemon thread. */
//        private boolean daemon = false;
//
//        Thread t = new Thread("我是线程");
//        boolean isDaemon = t.isDaemon();
//        System.out.println(isDaemon);// 输出false
//        int tPriority = t.getPriority();
//        System.out.println(tPriority);
//        String tName = t.getName();
//        System.out.println(tName);// 输出我是线程

//        long tid = t.getId();
//        System.out.println("线程ID：" + tid);// 输出线程ID：20
    }
}
