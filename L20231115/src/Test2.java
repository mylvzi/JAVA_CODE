/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-15
 * Time: 23:32
 */
public class Test2 {
    public static void main(String[] args) {
        Test.MinStack minStack = new Test.MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

        System.out.println(1);
    }
}
