package Thread4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-12-26
 * Time: 16:02
 */

enum SingletonEnum {
    INSTANCE; // 单例实例

    // 可以在枚举类型中添加其他方法或属性
}
public class Demo1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 尝试通过反射创建实例
        Class<?> c1 = SingletonEnum.class;
        Constructor<SingletonEnum> con = (Constructor<SingletonEnum>) c1.getDeclaredConstructor(String.class, int.class);
        con.setAccessible(true);

        SingletonEnum s1 = SingletonEnum.INSTANCE;
        SingletonEnum s2 = SingletonEnum.INSTANCE;

        System.out.println(s1 == s2); // 输出true，说明是同一个实例

        // 尝试通过反射创建实例，这里会抛出异常，因为枚举类型无法通过反射实例化
        try {
            SingletonEnum s3 = con.newInstance("someString", 42);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
