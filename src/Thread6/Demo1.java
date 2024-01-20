package Thread6;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:定时器的使用
 * User: 绿字
 * Date: 2023-12-26
 * Time: 19:10
 */
public class Demo1 {
    public static void main(String[] args) {

        // 创建出Timer类
        Timer timer = new Timer();

        // 通过schedule方法进行任务的设置
        timer.schedule(new TimerTask() {
            // 任务1将在1s后执行
            @Override
            public void run() {
                System.out.println("这是任务1");
            }
        },1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("这是任务2");
            }
        },2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("这是任务3");
                timer.cancel();// 执行完所有的任务后 终止timer内部的线程  否则会一直等待
            }
        },3000);

        System.out.println("定时器的使用");

        System.currentTimeMillis();
    }
}
