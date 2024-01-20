package Thread3;

/**
 * Created with IntelliJ IDEA.
 * Description:懒汉模式
 * User: 绿字
 * Date: 2023-12-25
 * Time: 11:04
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉模式存在线程安全问题
 * 原因在于   判断和创建实例  这两个操作不是原子的
 * 所以要加锁  使这两个操作成为原子的
 */
class SingleTonLazy {
    // 初始设置为null  这样就不会在类加载 的时候就创建出实例
    // 添加volatile是为了禁止new操作的 指令重排序
    private static volatile SingleTonLazy instance = null;

    public static SingleTonLazy getInstance() {
        // 最外面一层的if 加锁的频率太多了  是为了减少加锁的次数  避免不必要的开销  属于一种优化操作
        // 内层的if 仅仅是懒汉模式的特性  只有在调用的时候采取创建出对象
        if(instance == null) {
            // 加锁 是保证if 和new 操作的原子性
            synchronized (SingleTonLazy.class) {
                if (instance == null) {
                    instance = new SingleTonLazy();
                }
            }
        }
        return instance;
    }

    // 将构造方法设置为私有
    private SingleTonLazy() {
        if (instance != null) {
            throw new RuntimeException("无法创建出新的实例!!!");
        }


    };
}
public class Demo2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 通过反射获取到私有的构造方法
        Class<?> c1 = SingleTonLazy.class;
        Constructor<SingleTonLazy> con = (Constructor<SingleTonLazy>) c1.getDeclaredConstructor();
        con.setAccessible(true);

        // 创建出了一个新的实例
        SingleTonLazy s1 = con.newInstance();

        SingleTonLazy s2 = SingleTonLazy.getInstance();

        System.out.println(s1 == s2);// 输出false
    }
}
