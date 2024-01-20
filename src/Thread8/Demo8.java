package Thread8;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:ReentrantLock的简单使用
 * User: 绿字
 * Date: 2024-01-16
 * Time: 17:03
 */
public class Demo8 {
    public static void main(String[] args) {
        // 创建一个ReentrantLock对象
        ReentrantLock lock = new ReentrantLock();

        // 加锁
        lock.lock();
        try{
            // 需要加锁执行的代码
        }finally {
            // 注意ReentrantLock不会自动解锁 需要手动解锁!!!
            lock.unlock();
        }
    }
}
