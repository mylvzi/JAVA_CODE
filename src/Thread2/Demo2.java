package Thread2;

/**
 * Created with IntelliJ IDEA.
 * Description:死锁问题
 * User: 绿字
 * Date: 2023-12-21
 * Time: 21:07
 */

public class Demo2 {
    private static Object locker = new Object();

    public static void func1() {
        synchronized (locker) {
            func2();
        }
    }

    public static void func2() {
        func3();
    }

    public static void func3() {
        func4();
    }

    public static void func4() {
        synchronized (locker) {

        }
    }

}
