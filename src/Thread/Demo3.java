package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-07
 * Time: 10:00
 */

//class MyThread implements Runnable {
//    @Override
//    public void run() {
//
//        while(true) {
//            System.out.println("==");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
//public class Demo3 {
//    public static void main(String[] args) throws InterruptedException {
//        // 使用向上转型 是Java生态中的常见方式
//
//        // 先实现一个Runnable接口
//        Runnable runnable = new MyThread();
//        Thread thread = new Thread(runnable);
//        thread.start();
//
//        while (true) {
//            System.out.println("==");
//            Thread.sleep(1000);
//        }
//    }
//}
