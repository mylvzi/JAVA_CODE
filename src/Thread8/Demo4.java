package Thread8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:Callable接口的使用
 * User: 绿字
 * Date: 2024-01-12
 * Time: 13:00
 */

/**
 * 此处主要是和常规的Runnable接口进行一个对比
 * 通过Callable接口和FutureTask类的使用可以很好处理某些问题  如本例中的计算结果
 * 在Demo5中有常规的通过Runnable接口实现本例的代码
 * 注意刚开始学可能不太理解这里的逻辑  不明白这里的代码是干什么的
 * 简单来说就是通过另一个线程去执行计算的任务  而不是在主线程中去执行任务  这就是多线程并发执行
 * 对于这种有返回值的任务来说  使用Callable接口是一个更好的选择
 */
public class Demo4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用匿名内部类创建出Callable接口
        // 类似于Runnable接口 都适用于存储要执行的任务
        // 区别在于Callable接口里的任务有返回值
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }

                return sum;
            }
        };

        // Thread类不能直接使用Callble接口创建
        // 需要通过Runnable的子类FutureTask来实现
        // 这个子类还是很常见的  只是叫的名字不同  如JS中被称作promise
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // 创建一个线程 让线程执行上述的任务
        Thread t1 = new Thread(futureTask);
        t1.start();

        // get方法会接受任务的返回值
        // 但是可能存在Callable接口内部的任务还没有执行完毕
        // 此时get方法就会阻塞等待
        System.out.println(futureTask.get());
    }
}
