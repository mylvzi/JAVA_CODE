import java.sql.PreparedStatement;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:lambda表达式的使用
 * User: 绿字
 * Date: 2023-12-07
 * Time: 13:58
 */

@FunctionalInterface
interface FuncInterface1 {
    void test();
}

// 这样也是可以的
@FunctionalInterface
interface FuncInterface2 {
    void test();
    default void test2(){
        System.out.println("===");
    }
}

////无返回值无参数
//@FunctionalInterface
//interface NoParameterNoReturn {
//    void test();
//}
////无返回值一个参数
//@FunctionalInterface
//interface OneParameterNoReturn {
//    void test(int a);
//}
////无返回值多个参数
//@FunctionalInterface
//interface MoreParameterNoReturn {
//    void test(int a,int b);
//}
////有返回值无参数
//@FunctionalInterface
//interface NoParameterReturn {
//    int test();
//}
////有返回值一个参数
//@FunctionalInterface
//interface OneParameterReturn {
//    int test(int a);
//}
////有返回值多参数
//@FunctionalInterface
//interface MoreParameterReturn {
//    int test(int a,int b);
//}

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}

//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}

//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}
public class Test1 {
    public static void main(String[] args) {
//        // 创建线程 ->使用匿名内部类
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("hello thread");
//            }
//        };
//
//        // 这种方式可以降低耦合性(推荐)
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello thread2");
//            }
//        });

        // 方式1
        Thread thread1 = new Thread(() ->{
            System.out.println("hello thread1");
        });
        thread1.run();// 输出hello thread1

        //方式2  利用lambda表达式实例化一个runnable接口  降低耦合性
        Runnable runnable = () -> System.out.println("hello thread2");
        Thread thread2 = new Thread(runnable);
        thread2.run();// 输出hello thread2












//         使用匿名内部类实现Comparator接口
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2 - o1;
            }
        });

        // 使用lambda表达式实现优先级队列中的比较
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((o1,o2) ->{return o1-o2;});
















//        MoreParameterReturn moreParameterReturn = (x,y) -> {return x+y;};
//        System.out.println(moreParameterReturn.test(10, 20));// 输出30
//
//        // 使用匿名内部类
//        MoreParameterReturn moreParameterReturn1 = new MoreParameterReturn() {
//            @Override
//            public int test(int a, int b) {
//                return a+b;
//            }
//        };


//        OneParameterReturn oneParameterReturn = (x) -> {return x*x;};
//        System.out.println(oneParameterReturn.test(10));// 输出100
//
//        // 简化
//        OneParameterReturn oneParameterReturn1 = x -> x*x;
//        System.out.println(oneParameterReturn1.test(10));// 输出100
//
//        // 使用匿名内部类
//        OneParameterReturn oneParameterReturn2 = new OneParameterReturn() {
//            @Override
//            public int test(int a) {
//                return a*a;
//            }
//        };


//        NoParameterReturn noParameterReturn = () -> {return 10;};
//        System.out.println(noParameterReturn.test());// 输出10
//
//        // 简化
//        NoParameterReturn noParameterReturn1 = () ->10;
//        System.out.println(noParameterReturn1.test());// 输出10
//
//        // 使用匿名内部类
//        NoParameterReturn noParameterReturn2 = new NoParameterReturn() {
//            @Override
//            public int test() {
//                return 10;
//            }
//        };


//        // 使用lambda表达式
//        MoreParameterNoReturn moreParameterNoReturn = (x,y) -> System.out.println(x+y);
//        moreParameterNoReturn.test(10,20);// 输出30
//
//        // 使用匿名内部类
//        MoreParameterNoReturn moreParameterNoReturn1 = new MoreParameterNoReturn() {
//            @Override
//            public void test(int a, int b) {
//                System.out.println(a+b);
//            }
//        };













//        // 使用lambda表达式
//        OneParameterNoReturn oneParameterNoReturn = (x) -> System.out.println(x);
//        oneParameterNoReturn.test(10);// 打印10
//
//        // 使用匿名内部类
//        OneParameterNoReturn oneParameterNoReturn1 = new OneParameterNoReturn() {
//            @Override
//            public void test(int a) {
//                System.out.println(a);
//            }
//        };


//        // 使用lambda表达式重写函数式接口的抽象方法     参数       方法体
//        NoParameterNoReturn noParameterNoReturn1 = () -> System.out.println("hello1");
//        noParameterNoReturn1.test();// 输出hello1
//
//        // 使用匿名内部类重写函数式接口的抽象方法
//        NoParameterNoReturn noParameterNoReturn2 = new NoParameterNoReturn() {
//            @Override
//            public void test() {
//                System.out.println("hello2");
//            }
//        };

//        noParameterNoReturn2.test();// 输出hello2
    }
}
