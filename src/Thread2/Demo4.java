package Thread2;

/**
 * Created with IntelliJ IDEA.
 * Description:可重入锁的例子
 * User: 绿字
 * Date: 2023-12-22
 * Time: 14:55
 */

class MyClass {
    // 创建两个静态方法
    synchronized public static void methodA() {
        System.out.println("这是methodA");
        methodB();
    }

    synchronized public static void methodB() {
        System.out.println("这是methodB");
    }

    public static void main(String[] args) {
        // 调用类方法  此时synchronized是对类对象进行加锁
        MyClass.methodA();
    }
}


public class Demo4 {

}
