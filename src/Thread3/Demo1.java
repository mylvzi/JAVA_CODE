package Thread3;

/**
 * Created with IntelliJ IDEA.
 * Description:饿汉模式
 * User: 绿字
 * Date: 2023-12-25
 * Time: 10:13
 */


class SingleTon {
    // 将唯一的实例设置为类对象  使用static修饰
    private static SingleTon instance = new SingleTon();

    // 设置唯一的获取方法
    public static SingleTon getInstance() {
        return instance;
    }

    // 为了保证类外不能再创建新的实例  将构造方法设置为私有的
    private SingleTon() {

    }
}
public class Demo1 {
    public static void main(String[] args) {
        SingleTon s = SingleTon.getInstance();
        // 如果尝试再次创建一个新的实例  就会报错
//        SingleTon s1 = new SingleTon();
    }
}
