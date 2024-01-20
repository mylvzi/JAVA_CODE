package Thread8;

/**
 * Created with IntelliJ IDEA.
 * Description:基于CAS实现一个自旋锁
 * User: 绿字
 * Date: 2024-01-12
 * Time: 18:01
 */
//class SpinLock {
//    // 此处owner就相当于"内存值"
//    private Thread owner = null;
//
//    // 其他线程进行加锁
//    public void lock() {
//        // 通过CAS来判断当前锁是否被其他线程持有
//        // 如果没由被其他线程持有 就是null  当前线程就可以持有这个锁
//        // 如果不为null  证明这个锁已经被其他线程持有  当前线程需要等待
//        while (!CAS(this.owner,null,Thread.currentThread())) {
//
//        }
//    }
//
//    // 解锁
//    public void unlcok() {
//        this.owner = null;
//    }
//}
//public class Demo7 {
//}
