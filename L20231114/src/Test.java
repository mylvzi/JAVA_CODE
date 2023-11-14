import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-14
 * Time: 17:16
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {43,12,3,67,32,40,100};
//        Sort.insertSort(arr);
//        Sort.shellSort(arr);
//        Sort.selectSort(arr);
//        Sort.heapSort(arr);
//        Sort.bubbleSort(arr);
        Sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
