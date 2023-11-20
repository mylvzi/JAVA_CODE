import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:栈 后进先出
 * User: 绿字
 * Date: 2023-10-19
 * Time: 20:40
 */
public class MyStack {
    /**
     * 栈的实现一：用数组实现栈
     */
    private int[] elem;
    private int usedSize;

    private static final int DEFAULTCAPACITY = 10;

    public MyStack() {
        this.elem = new int[DEFAULTCAPACITY];
    }

    public MyStack(int size) {
        this.elem = new int[size];
    }

    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        this.elem[usedSize] = val;
        this.usedSize++;
    }

    private boolean isFull() {
        return this.usedSize == this.elem.length;
/*        if (this.elem.length == this.usedSize) {
            return true;
        }

        return false;*/
    }

    public int pop() {
        if (isEmpty()) {
            throw new StackEmptyException("栈区之内不含有数据,无法删除");
        }

//        this.usedSize--;
//        return this.elem[usedSize];

        int oldVal = this.elem[usedSize-1];
        this.usedSize--;
        return oldVal;
    }

    public int peek() {
        if (isEmpty()) {
            throw new StackEmptyException("栈区之内不含有数据,无法删除");
        }

        return this.elem[usedSize-1];
    }

    public boolean isEmpty() {

        return this.usedSize == 0;
/*        if (this.usedSize == 0) {
            return true;
        }

        return false;*/
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "elem=" + Arrays.toString(elem) +
                ", usedSize=" + usedSize +
                '}';
    }


}

///**
// * 用队列实现栈  使用两个队列实现栈
// * 队列:先进先出  栈:后进先出
// * 要明白,一个队列无法实现栈,他们有本质上的区别
// * 入栈:入到不为空的队列之中  如果两个都为空,入到第一个队列之中
// * 出栈:出栈顶元素,后进先出  对应的是队列中的队尾元素  将队尾元素之前的所有元素转移到另一个队列之中,再返回队尾元素
// */
//class MyStack2 {
//    private Queue<Integer> que1;
//    private Queue<Integer> que2;
//
//
//    public MyStack2() {
//        this.que1 = new LinkedList<>();
//        this.que2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        // 入栈到不为空的队列之中
//        if(!que1.isEmpty()) {
//            que1.offer(x);
//        } else if (!que2.isEmpty()) {
//            que2.offer(x);
//        }else {
//            que1.offer(x);
//        }
//
//
//    }
//
//    public int pop() {
//        // 出栈
//        // 为空  直接返回
//        if (empty()) {
//            return -1;
//        }
//
//
//        if (!que1.isEmpty()) {
//            int size = que1.size();
//            for (int i = 0; i < size - 1; i++) {
//                // 将que1队尾元素前面的所有元素转移到que2中
//                que2.offer(que1.poll());
//            }
//            return que1.poll();
//        } else {
//            int size = que2.size();
//            for (int i = 0; i < size - 1; i++) {
//                // 将que2队尾元素前面的所有元素转移到que1中
//                que1.offer(que2.poll());
//            }
//            return que2.poll();
//        }
//
//    }
//
//    public int top() {
//        // 为空  直接返回
//        if (empty()) {
//            return -1;
//        }
//
//        int tmp = -1;
//
//        if (!que1.isEmpty()) {
//            int size = que1.size();
//            for (int i = 0; i < size; i++) {
//                // 将que1队尾元素前面的所有元素转移到que2中
//                tmp = que1.poll();
//                que2.offer(tmp);
//            }
//            return tmp;
//        } else {
//            int size = que2.size();
//            for (int i = 0; i < size - 1; i++) {
//                // 将que2队尾元素前面的所有元素转移到que1中
//                tmp = que2.poll();
//                que1.offer(tmp);
//            }
//            return tmp;
//        }
//
//    }
//
//    public boolean empty() {
//        // 当两个队列都为空时,栈就为空
//        return que1.isEmpty() && que2.isEmpty();
//    }
//}
//
//
///**
// * 思路2:使用一个队列实现栈
// * 栈:后进先出   队列:先进后出
// * 保证队头的元素时最后一个入栈的
// * 新入一个元素的时候将之前所有元素都poll出去,再重新入队,那么新元素就是队头了
// * 这样就实现了后进先出
// */
//class MyStack2 {
//
//    Queue<Integer> queue;
//
//    public MyStack2() {
//        this.queue = new LinkedList<>();
//    }
//
//
//    public void push(int x) {
//        int n = queue.size();
//        queue.offer(x);
//
//        for (int i = 0; i < n; i++) {
//            // 重新入队
//            queue.offer(queue.poll());
////            int ret = queue.poll();
////            queue.offer(ret);
//        }
//
//    }
//
//    public int pop() {
//        return queue.poll();
//    }
//
//    public int top() {
//        return queue.peek();
//    }
//
//    public boolean empty() {
//        return queue.isEmpty();
//    }
//}
//
//
///**
// * 思路3:使用两个队列
// * 始终保持一个队列为空,一个队列始终是满的
// * 将元素先入到que2中,再将que1全部元素入到que2中,交换,则此时que1的队头就是后入栈的元素,que2还是空
// */
//class MyStack2 {
//    private Queue<Integer> que1;
//    private Queue<Integer> que2;
//
//
//    public MyStack2() {
//        this.que1 = new LinkedList<>();
//        this.que2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        que2.offer(x);
//        int size = que1.size();
//        for (int i = 0; i < size; i++) {
//            // 将que1的全部元素转移到que2中
//            que2.offer(que1.poll());
//        }
//
//        Queue<Integer> tmp = que1;
//        que1 = que2;
//        que2 = tmp;
//
//    }
//
//    public int pop() {
//        return que1.poll();
//    }
//
//    public int top() {
//        return que1.peek();
//    }
//
//    public boolean empty() {
//        return que1.isEmpty();
//    }
//}


class Mystack3 {
    // 使用链表模拟栈
    /**
     * 栈只能在一端进行数据的操作
     * 在这里我们只在链表的last进行数据的操作
     */
    LinkedList<Integer> mystack = new LinkedList<>();

    // push
    public void push(int data) {
        mystack.addLast(data);
    }

    // pop
    public int pop() {
        if(mystack.isEmpty()) {
            return -1;// 抛异常也可以
        }
        return mystack.pollLast();
    }

    public int peek() {
        return mystack.peekLast();
    }

    public static void main(String[] args) {
        Mystack3 mystack3 = new Mystack3();
        mystack3.push(1);
        mystack3.push(2);
        mystack3.push(3);

        System.out.println(mystack3.pop());// 3
        System.out.println(mystack3.peek());// 2
    }
}

























