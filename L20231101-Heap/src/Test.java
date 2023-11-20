import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-01
 * Time: 17:31
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        TestHeap testHeap = new TestHeap(5);

        testHeap.createHeap();

        testHeap.headSort();

        System.out.println("===");
    }
    public static void main5(String[] args) {
        int[] arr = {1,2,3,4,5};
//        TestHeap testHeap = new TestHeap(10);

//        System.out.println(testHeap.maxKestK(arr,3));

    }
    public static void main3(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    }
    public static void main4(String[] args) {
//        int[] arr = {27,15,19,18,28,34,65,49,25,37};
//        TestHeap testHeap = new TestHeap(10);
//        testHeap.initHeap(arr);
//        testHeap.createHeap();
//
//        System.out.println("==");
////
////        testHeap.createHeap();
////
////        System.out.println("====");
////
//        int top = testHeap.poll();
//        System.out.println(top);

//        testHeap.offer(80);
//
//        System.out.println('=');


        // 第k大/小元素

        //  前k个元素存储到大根堆中  堆里存放最大的k个元素 以小根堆的形式存储  则堆头一定是第k大的元素



    }
}
