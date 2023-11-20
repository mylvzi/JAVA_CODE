import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-20
 * Time: 19:49
 */
public class Test1 {
    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.push(1);
        myQueue2.push(2);
//        myQueue2.push(3);
//        myQueue2.push(4);
        myQueue2.peek();
        myQueue2.pop();
    }
    public static void main2(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.offer(5);

        System.out.println(myQueue.peek());

//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());


    }
    public static void main1(String[] args) {
        // 队列的底层是双向链表  即LinkedList
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
