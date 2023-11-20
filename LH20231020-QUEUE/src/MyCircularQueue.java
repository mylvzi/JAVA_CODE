/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-20
 * Time: 21:09
 */
public class MyCircularQueue {
    /**
     * 使用数组实现循环队列1
     */
    private int[] elem;
    private int front;
    private int rear;


    public MyCircularQueue(int k) {
        // 因为我预留了一个位置不放元素  所以实际数组的大小是k+1
        this.elem = new int[k+1];
    }

    // 插入元素
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        this.elem[rear] = value;
        // rear++; 是错误的,这样无法实现"循环",且会越界
        rear = (rear+1)% elem.length;
        return true;

    }

    public boolean deQueue() {
        // 1.为空   返回-1
        if (isEmpty()) {
            return false;
        }

        // 2.不为空  front走到下一个位置
        front = (front+1)% elem.length;
        return true;
    }

    // 得到队头元素
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return this.elem[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        // 因为是循环队列,0下标的前一个就是最后一个元素
        int index = (rear==0) ? (elem.length-1):(rear-1);
        return this.elem[index];

    }

    /**
     * 预留一个空间  front== rear  为空  rear的下一个是front未满  不走到下一个
     * 如果不预留空间  则最后rear一定会走到front
     * 当然也可以设计一个计数器  cnt == length  满  cnt == 0;  空
     * 如何体现预留呢?-- rear的下一个是front就认为是满的  即rear所在的位置不再放元素
     * @return
     */

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear+1) % this.elem.length == front;
//        if((rear+1) % this.elem.length == front){
//            return true;
//        }
//        return false;
    }
}

class MyCircularQueue2{
    /**
     * 使用数组实现循环队列2  不预留空间  设计一个计数器来判断是满还是空
     */
    private int[] elem;
    private int front;
    private int rear;
    private int cnt;// 计数器

    public MyCircularQueue2(int k) {
        this.elem = new int[k];
    }

    // 插入元素
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        this.elem[rear] = value;
        // rear++; 是错误的,这样无法实现"循环",且会越界
        rear = (rear+1)% elem.length;
        cnt++;
        return true;

    }

    public boolean deQueue() {
        // 1.为空   返回-1
        if (isEmpty()) {
            return false;
        }

        // 2.不为空  front走到下一个位置
        front = (front+1)% elem.length;
        cnt--;
        return true;
    }

    // 得到队头元素
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return this.elem[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        // 因为是循环队列,0下标的前一个就是最后一个元素
        int index = (rear==0) ? (elem.length-1):(rear-1);
        return this.elem[index];

    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        // 元素个数等于数组长度  满
        return cnt == elem.length;
    }
}
