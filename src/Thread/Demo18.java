package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-19
 * Time: 14:08
 */
public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t= new Thread(() -> {
            // 先获取当前Thread的实例  在判断其自带的标志位isInterrupted
            while (!Thread.currentThread().isInterrupted()) {
                while (true) {
                    System.out.println("Thread is working");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // 1.方式1  不管不顾  让t线程继续运行
                        e.printStackTrace();

                        // 2.方式2 使用break直接中断进程
                        // 3.方式3  捕获到线程之后处理其他工作的代码
                        // 此处就存放需要解决的其他工作的代码
                    }
                }
            }
        });

        t.start();
        Thread.sleep(3000);
        // 此方法就是将自带的标志位isInterrupted设置为true
        t.interrupt();
    }
}
