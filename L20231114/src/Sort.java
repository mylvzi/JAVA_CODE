/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-14
 * Time: 17:12
 */
public class Sort {
    /**
     * 插入排序
     * 时间：0(n2)
     * 空间：0(1)
     * 就是整理扑克牌的过程
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }

            arr[j+1] = tmp;
        }
    }

    /**
     * 希尔排序  分组优化的直接插入排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        // 跳跃式分组进行排序
        int gap = arr.length;
        while (gap > 0) {
            gap /= 2;
            shell(arr,gap);
        }
    }

    private static void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-gap;
            for (; j >= 0; j-= gap) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }

            arr[j+gap] = tmp;
        }
    }

    /**
     * 选择排序
     */

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 堆排  从小到大
     * 1.创建大根堆
     * 2.交换  向下调整
     */

    public static void heapSort(int[] arr) {
        creatBigHeap(arr);
        int end = arr.length-1;
        while(end > 0) {
            swap(arr,0,end);
            shiftDown(arr,0,end);
            end--;
        }
    }

    private static void creatBigHeap(int[] arr) {
        for (int parent = (arr.length-1-1)/2; parent >= 0; parent--) {
            shiftDown(arr,parent,arr.length);
        }
    }

    private static void shiftDown(int[] arr, int parent, int end) {
        int child = 2*parent+1;
        while (child < end) {
            // 判断左右孩子谁是最大的
            if(child+1 < end && arr[child] < arr[child+1]) {
                child++;
            }

            if(arr[child] > arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    flg = true;
                }
            }

            // 如果flg为false 证明在上面的交换过程中未发生交换  序列有序
            if(!flg) {
                break;
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int start, int end) {
        if(start >= end) return;

        // 三数取中
        midOfThree(arr,start,end);



        int pivot = parttion(arr,start,end);

        quick(arr,start,pivot-1);

        quick(arr,pivot+1,end);
    }

    private static void midOfThree(int[] arr, int left, int right) {
        // 使最左边的元素处于中间大的值  防止出现极端情况（首元素最大或最小   此时时间复杂度为O(N^2)）
        int mid = (left+right) / 2;
        if(arr[left] < arr[right]) {// 保证左边元素是较大值
            swap(arr,left,right);
        }

        if(arr[mid] < arr[right]) {// 保证中间边元素是较大值
            swap(arr,mid,right);
        }

        if(arr[left] > arr[mid]) {
            swap(arr,left,mid);
        }
    }

    private static int parttion(int[] arr, int left, int right) {
        int key = arr[left];

        while(left < right) {
            while(left < right && arr[right] >= key) {
                right--;
            }

            arr[left] = arr[right];

            while(left < right && arr[left] <= key) {
                left++;
            }

            arr[right] = arr[left];
        }

        arr[left] = key;
        return left;
    }

}



