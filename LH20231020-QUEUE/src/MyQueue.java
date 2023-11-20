/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-20
 * Time: 20:19
 */

import java.util.Stack;

/**
 * 双向链表实现队列
 */
public class MyQueue {

    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode front;// 队头
    private ListNode rear; // 队尾
    private int usedSize;

    /**
     * 实现队尾进，队头出
     */

    public void offer(int x) {
        ListNode node = new ListNode(x);
        if (rear == null) {
            front = rear = node;
            this.usedSize++;
            return;
        }

        rear.next = node;
        node.prev = rear;
        rear = node;

        this.usedSize++;
    }

    public int poll() {
        if (front == null) {
            throw new QueueEmptyException("队列为空，无法返回数据");
        }

        int ret = front.val;

        // 如果只有一个节点  要把front和rear都置空
        if (front.next == null) {
            front = null;
            rear = null;
            return ret;
        }

        front = front.next;
        front.prev = null;

        this.usedSize--;
        return ret;
    }

    public int peek() {
        if (front == null) {
            throw new QueueEmptyException("队列为空，无法返回数据");
        }

        int ret = front.val;
        return ret;
    }

    public int size() {
        return this.usedSize;
    }

    public boolean empty() {
        return this.usedSize==0;
    }

}

/**
 * 用栈实现队列  两个栈  一个永远为空，一个永远为满
 * stack1为满的  stack2为空
 */
class MyQueue2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        // stack1的栈底元素才是我第一个要出的元素
        stack1.push(x);

    }

    public int pop() {
        if(stack2.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }
}
