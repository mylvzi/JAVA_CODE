package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-20
 * Time: 10:35
 */
public class Demo20 {
    public static void main(String[] args) throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread.sleep(1000);// 休眠1s
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - beg) + " ms");// 输出1003
    }
}
