package Thread7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * Description:线程池代码
 * User: 绿字
 * Date: 2023-12-29
 * Time: 14:09
 */
public class Demo1 {
    public static void main(String[] args) {
        // 向上转型
        ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service1 = Executors.newFixedThreadPool(4);
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        ExecutorService service4 = Executors.newScheduledThreadPool(10);


        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) service1;
        System.out.println(threadPoolExecutor.getCorePoolSize());// 输出4



//        ExecutorService service2 = Executors.newSingleThreadExecutor();
//        ExecutorService service3 = Executors.newScheduledThreadPool(4);
//
//
//
//        service.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("任务提交");
//            }
//        });

    }
}
