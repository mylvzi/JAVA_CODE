package Thread8;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:Semaphore的基本使用
 * User: 绿字
 * Date: 2024-01-16
 * Time: 20:11
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
    }
}
