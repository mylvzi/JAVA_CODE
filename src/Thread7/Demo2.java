package Thread7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:ThreadFactory的简单使用
 * User: 绿字
 * Date: 2023-12-30
 * Time: 15:23
 */

// 创建自定义的线程  先让其实现ThreadFactory接口
class MyCustomThread implements ThreadFactory {
    // 设置属性  自定义线程的前缀
    private final String threadNamePrefix = "MyCustomThread - ";

    // 自定义线程的编号
    private int threadCnt = 0;

    @Override
    public Thread newThread(Runnable r) {
        // 规定线程要执行的任务
        Thread t = new Thread(r);
        t.setName(threadNamePrefix + ++threadCnt);
        return t;
    }


}
public class Demo2 {
    public static void main(String[] args) {
        MyCustomThread myCustomThread = new MyCustomThread();

        // 利用自定义线程创建出线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5,myCustomThread);

        // 提交任务
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    // 打印当前正在执行任务的线程名称
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
