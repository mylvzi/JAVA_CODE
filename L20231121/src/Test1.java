import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-21
 * Time: 14:38
 */
//class MyCircularQueue {
////
////    private int[] elem;
////    private int front;
////    private int rear;
////    private int cnt = 0;
////
////
////    public MyCircularQueue(int k) {
////        this.elem = new int[k];
////    }
////
////    public boolean enQueue(int value) {
////        // 插入数据
////        if(isFull()) {
////            return false;
////        }
////
////        this.elem[rear] = value;
////        rear = (rear+1) % elem.length;
////        cnt++;
////        return true;
////
////    }
////
////    public boolean deQueue() {
////        if(isEmpty()) {
////            return false;
////        }
////
////        front = (front+1) % elem.length;
////        cnt--;
////        return true;
////
////    }
////
////    public int Front() {
////        return this.elem[front];
////    }
////
////    public int Rear() {
////        int index = (rear == 0) ? (elem.length-1) : (rear-1);
////        return this.elem[index];
////    }
////
////    public boolean isEmpty() {
////        return cnt == 0;
////    }
////
////    public boolean isFull() {
////        return cnt == this.elem.length;
////    }
////}
//
////class MyCircularQueue {
////
////    private int[] elem;
////    private int front;
////    private int rear;
////
////    public MyCircularQueue(int k) {
////        this.elem = new int[k+1];
////    }
////
////    public boolean enQueue(int value) {
////        // 插入数据
////        if(isFull()) {
////            return false;
////        }
////
////        this.elem[rear] = value;
////        rear = (rear+1) % elem.length;
////        return true;
////
////    }
////
////    public boolean deQueue() {
////        if(isEmpty()) {
////            return false;
////        }
////
////        front = (front+1) % elem.length;
////        return true;
////
////    }
////
////    public int Front() {
////        return this.elem[front];
////    }
////
////    public int Rear() {
////        int index = (rear == 0) ? (elem.length-1) : (rear-1);
////        return this.elem[index];
////    }
////
////    public boolean isEmpty() {
////        return rear == front;
////    }
////
////    public boolean isFull() {
////        return (rear+1) % elem.length == front;
////    }
//}

class MyCircularDeque {
    private int[] elem;
    private int front;
    private int rear;

    public MyCircularDeque(int k) {
        this.elem = new int[k+1];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        this.elem[front] = value;
        front = (front+1) % elem.length;
        return true;
    }

    public boolean insertLast(int value) {
        // 插入数据
        if(isFull()) {
            return false;
        }

        this.elem[rear] = value;
        rear = (rear+1) % elem.length;
        return true;

    }

    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }

        front = (front+1) % elem.length;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }

        rear = (rear+1) % elem.length;
        return true;

    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elem[front];

    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elem[rear];

    }

    public boolean isEmpty() {
        return front == rear;

    }

    public boolean isFull() {
//        return (rear - front + elem.length) % elem.length == elem.length-1;

        return ((rear+1)% elem.length == front) || ((front+1)% elem.length == rear);
//
    }
}


public class Test1 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertFront(1);
        myCircularDeque.insertFront(2);

        System.out.println("==");
    }
//    public boolean IsPopOrder (int[] pushV, int[] popV) {
//        // write code here
//        int size = 0,j=0;
//        for (int num:pushV) {
//            pushV[size] = num;
//
//            // 出栈序列和栈顶元素相等  模拟出栈
//            while(size >=0 && popV[j] == pushV[size]) {
//                size--;
//                j++;
//            }
//
//            size++;
//        }
//
//        return size == 0;
//    }
//    public boolean IsPopOrder (int[] pushV, int[] popV) {
//        // write code here
//        // 使用辅助栈 模拟出栈的过程
//
//        Stack<Integer> stack = new Stack<>();
//        int j = 0;// 遍历出栈序列
//        for (int i = 0; i < pushV.length; i++) {
//            stack.push(pushV[i]);
//
//            while (!stack.isEmpty() && stack.peek() == popV[j]) {
//                stack.pop();
//            }
//        }
//
//        return stack.isEmpty();
//    }
}
