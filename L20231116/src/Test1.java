/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-16
 * Time: 19:20
 */
public class Test1 {
    static class MinStack {
        // 使用链表实现
        private class Node{
            int val;
            int min;
            Node next;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
                this.next = null;
            }

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        private Node head;

        public void push(int x) {
            if(head == null) {
                head = new Node(x,x);
            }else {
                Node newNode = new Node(x,Math.min(x,head.min),head);
                newNode = head;
            }

        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(3);

        System.out.println("==");
    }
}
