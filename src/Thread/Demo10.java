package Thread;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-07
 * Time: 23:23
 */

class Demo {
    public void func() {
        System.out.println("hello");
    }
}

@FunctionalInterface
interface DemoTest {
    void func();
}
public class Demo10 {
    // 使用类变量  可以直接访问
    public static int a = 10;
    public static void main(String[] args) {
        // lambda表达式
        DemoTest demoTest = () -> {
            System.out.println(a);
        };

    }




    public static void main2(String[] args) {
        int a = 10;
        new Demo() {
            @Override
            public void func() {
                System.out.println(a);
            }
        };
    }
}
