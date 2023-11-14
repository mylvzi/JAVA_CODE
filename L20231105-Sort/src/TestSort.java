import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-05
 * Time: 15:35
 */
public class TestSort {
    public static void order(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public static void norOrder1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length-i;
        }
    }

    public static void norRandomOrder(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10_000);
        }
    }

    public static void testInsertSort(int[] arr) {
        int[] tmp = Arrays.copyOf(arr,arr.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(tmp);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序的耗时：" + (endTime - startTime));

    }

    public static void testShelltSort(int[] arr) {
        int[] tmp = Arrays.copyOf(arr,arr.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(tmp);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序的耗时：" + (endTime - startTime));

    }

    public static void testHeapSort(int[] arr) {
        int[] tmp = Arrays.copyOf(arr,arr.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(tmp);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序的耗时：" + (endTime - startTime));

    }

    public static void testQuickSort(int[] arr) {
        int[] tmp = Arrays.copyOf(arr,arr.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(tmp);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序的耗时：" + (endTime - startTime));

    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,1,5,4,3,6,8,9,6,7,6,3,1,1};
        Sort.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void main3(String[] args) {
//        int[] arr = {1,9,5};
//        Sort.bubbleSort(arr);
//        Sort.quickSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[1000];
        norRandomOrder(arr);
//        norOrder1(arr);
        testQuickSort(arr);
//        norRandomOrder(arr);
////        testInsertSort(arr);// 10
//       testShelltSort(arr);// 7
//        testHeapSort(arr);



//        int[] arr = new int[10_000];
//        order(arr);
//        testInsertSort(arr);// 2
//        System.out.println("======");
//        norOrder1(arr);
//        testInsertSort(arr);// 31
//        System.out.println("=======");
//        norRandomOrder(arr);
//        testInsertSort(arr);// 15





//       int[] arr = {23,12,45,1,89,89,34};
//        Sort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

}
