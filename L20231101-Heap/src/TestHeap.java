/**
 * Created with IntelliJ IDEA.
 * Description: 堆的实现
 * User: 绿字
 * Date: 2023-11-01
 * Time: 17:31
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆可以理解为一种特殊的完全二叉树
 * 分为大根堆 小根堆
 */
public class TestHeap {
    // 根据传入的数组  将他们调整为大根堆

    public int[] elem;
    public int usedSize;

    public TestHeap(int size) {
        this.elem = new int[size];
    }

    // 初始化堆
    public void initHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }


    }

    // 实现大根堆

    /**
     * 从最后一棵子树的根节点开始，进行向下调整，一直调整到root
     */
    public void createHeap() {
        for (int parent =(usedSize-1-1)/2 ; parent >=0 ; parent--) {
            shiftDown2(parent,usedSize);
        }
    }

    private void shiftDown(int parent, int usedSize) {
        int child = 2 * parent+1;// 得到左孩子的下标
        while (child < usedSize) {
            // 首先要保证child是左右孩子最大元素的下标
            if(child + 1 < usedSize && elem[child] < elem[child+1]) {
                // 有右孩子  且右孩子的值比左孩子大
                child++;
            }

            // 此时child就是值最大孩子的下标
            if(elem[child] > elem[parent]) {
                swap(child,parent);
                parent = child;
                child = 2 * (parent+1);
            }else {
                break;
            }
        }
    }

    // 实现小根堆
    private void shiftDown2(int parent, int usedSize) {
        int child = 2 * parent+1;// 得到左孩子的下标
        while (child < usedSize) {
            // 首先要保证child是左右孩子最大元素的下标
            if(child + 1 < usedSize && elem[child] > elem[child+1]) {
                // 有右孩子  且右孩子的值比左孩子大
                child++;
            }

            // 此时child就是值最大孩子的下标
            if(elem[child] < elem[parent]) {
                swap(child,parent);
                parent = child;
                child = 2 * (parent+1);
            }else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }


    // 在堆内添加元素
    /**
     * 插入到最后一个位置（保证是一个完全二叉树，且方便后续操作）
     * 向上调整
     */

    public void offer(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        this.elem[usedSize] = val;
        shiftUp(usedSize);
        this.usedSize++;
    }

    private void shiftUp(int child) {
        int parent = (child-1)/2;

        while(child != 0) {
            if(elem[child] > elem[parent]) {
                swap(child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    // 删除  一定是删除优先级最高的元素  最后返回优先级最高的那个元素
    public int poll() {
        int tmp = this.elem[0];
        // 交换第一个元素和最后一个元素  让第一个元素  处在优先级最低的位置  即二叉树的最后一个结点
        swap(0,usedSize-1);
        this.usedSize--;
        shiftDown(0,usedSize);
        return tmp;
    }


    /**
     * top-k问题  返回前k个最大/最小的元素  这里以前k个最小为例
     * 1.最简单的思路：对数组进行排序
     * 2.直接使用堆（优先级队列）的特性  创建小根堆  poll k次即可
     * 3。建立一个k个结点的大根堆  再与数组剩余元素进行比较（重点掌握）
     */

    // 解法1
    public int[] smallestK1(int[] arr, int k) {
        int[] ret = new int[k];
        if(arr == null || k <= 0) return ret;

        Arrays.sort(arr);

        // 排序之后  arr从小到大排列完毕
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }

        return ret;
    }


    // 解法2
    public int[] smallestK2(int[] arr, int k) {
        int[] ret = new int[k];
        if(arr == null || k <= 0) return ret;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }


        return ret;
    }


    // 解法3  效率最高的一种方法  创建一个具有k个结点的大根堆

    // 注意  优先级队列默认是小根堆  要实现大根堆  需要先创建一个实现了Comparator接口的对象
    class IntCmp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if(arr == null || k <= 0) return ret;

        // 创建一个具有k个结点的大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new IntCmp());

        for (int i = 0; i < k; i++) {
            // 将前k个元素做成大根堆
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            // 去和栈顶元素比较
            if (arr[i] < priorityQueue.peek()) {
                // 证明栈顶元素不是前k个最小的元素  要删除
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }

        return ret;
    }


    // 求数组中第k大/小元素

    //  前k个元素存储到小根堆中  堆里存放最大的k个元素 以小根堆的形式存储  则堆头一定是第k大的元素
    public int maxKestK(int[] arr, int k) {
        if(arr == null || k <= 0) {
            throw new ArrayEmptyException("不含有元素或k不合法");
        }

        // 创建一个具有k个结点的大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            // 将前k个元素做成小根堆
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
I
        return priorityQueue.poll();

    }


    // 堆排序
    // 升序  从小到大  创建大根堆
    // 降序  从大到小  创建小根堆

    /**
     * 升序  调整为大根堆  堆首元素一定是最大的
     * 交换堆首和堆尾元素  向下调整（不包含被调下去的最大元素）  使第二大的元素位于堆顶
     * 重复上述操作  每次都是堆首元素和堆尾元素进行交换
     */

    public void headSort() {
        int end = usedSize-1;
        while(end > 0) {
            swap(0,end);
            shiftDown(0,end);
            end--;
        }
    }


































}
