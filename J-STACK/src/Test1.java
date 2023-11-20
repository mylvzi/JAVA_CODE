import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:Java中的stack
 * User: 绿字
 * Date: 2023-10-19
 * Time: 20:48
 */
public class Test1 {
    /**
     * 链式栈
     * @param args
     */
    public static void main2(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Object[] s= stack.toArray();
        for (Object x: s) {
            System.out.println(x);
        }
        System.out.println(stack.peek());
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 栈的创建  栈在Java中就是一个类！！！
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // 使用构造器
        Iterator<Integer> it= stack.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");// 1 2 3 4
        }
        System.out.println();
        System.out.println("============================");
        // 重写了toString方法  直接传对象 即可打印内容
        System.out.println(stack);// 1 2 3 4

        // pop会删除栈顶元素
        stack.pop();
        System.out.println(stack);// 1 2 3

        // peek  瞄一眼  不会把top删除
        int x = stack.peek();
        System.out.println(x);// 3
    }
}
