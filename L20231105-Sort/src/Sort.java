import java.util.Arrays;
import java.util.Stack;

import static com.sun.deploy.net.MessageHeader.merge;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-05
 * Time: 15:30
 */
public class Sort {

    /**
     * 插入排序  在一个已经存在的序列中  插入到合适位置
     * 时间复杂度：
     *          最好情况：O(N)
     *          最坏情况:O(N^2)
     * 空间复杂度：
     *          O(1)
     * 稳定性：是一个稳定的排序
     * 所以对于一个有序的序列来说  插入排序就是最快的
     */

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                // >tmp  j向后挪动
                if(arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    // 要插入的元素已经是最大的了  不需要再去比较了
                    //arr[j+1] = tmp;
                    break;
                }
            }

            // 跳出循环有两种情况  1.tmp是最小的需要插入到第一个元素 此时j=-1  结束条件是j不>=0了   2.else语句中的break；
            arr[j+1] = tmp;
        }
    }


    /**
     * 希尔排序  优化的插入排序
     * 先进行预排序  跳跃式进行分组  分的组数逐渐减少  直到组数为1
     * 分组优化
     * 时间复杂度：O(N^1.3)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */

    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            shell(arr,gap);
        }
    }

    private static void shell(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-gap;
            for (; j >= 0; j-= gap) {
                // >tmp  j向后挪动
                if(arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                }else {
                    // 要插入的元素已经是最大的了  不需要再去比较了
                    //arr[j+1] = tmp;
                    break;
                }
            }

            arr[j+gap] = tmp;
        }

    }
    
    
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

    private static void swap(int[] arr, int i, int minIndex) {
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }


    /**
     * 堆排
     * 时间复杂度：O(N*logN) + O(N) = O(N*logN);目前是最快的
     * 空间复杂度：O(1)
     */
    public static void heapSort(int[] arr) {
        createBigHeap(arr);
        int end = arr.length-1;
        while(end > 0) {
            swap(arr,0,end);
            // 注意向下调整的过程中必须实时更新 边界范围 也就是end（以前是usedSize）
            shiftDown(arr,0,end);
            end--;
        }
    }

    private static void createBigHeap(int[] arr) {
        for (int parent = (arr.length-1-1)/2; parent >= 0; parent--) {
            shiftDown(arr,parent,arr.length);
        }
    }

    private static void shiftDown(int[] arr,int parent,int end) {
        int child = 2*parent+1;
        // 设计成这样主要是在堆排的过程中不能再考虑堆尾元素
        while(child < end) {
            if(child + 1 < end && arr[child] < arr[child+1]) {
                child++;
            }

            if(arr[parent] < arr[child]) {
                swap(arr,parent,child);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }


    /**
     *  冒泡排序
     *  时间复杂度：O(N^2)  最好（加了优化）O(N)
     *  空间复杂度：O(1)
     *  稳定性好
     */

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    flg = true;
                }
            }

            if(!flg) {
                return;
            }
        }
    }


    /**
     * 快速排序
     *时间复杂度：O(N*logN);  每次分而治之需要遍历的数字都是N  最好情况是一颗完全二叉树  高度为logN  所以时间复杂度是N*logn
     *
     * 容易溢出  占用内存大
     * 三种写法：hore法  挖坑法（推荐） 前后指针法
     * 递归方法  最好的情况是一种完全二叉树
     */
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr,int start,int end) {
        if(start >= end) return;

        if(end - start + 1 > 7) {
            insertSortRange(arr,start,end);
            return;
        }

        midOfThree(arr,start,end);



        // 获得按照规则交换后的基准值的下标
        int pivot = parttion(arr,start,end);

        // 遍历左子树  分而治之
        quick(arr,start,pivot-1);

        // 遍历右子树  分而治之
        quick(arr,pivot+1,end);

    }

    public static void insertSortRange(int[] arr,int begin,int end) {

        for (int i = 1; i <= end; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >= begin; j--) {
                // >tmp  j向后挪动
                if(arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    // 要插入的元素已经是最大的了  不需要再去比较了
                    //arr[j+1] = tmp;
                    break;
                }
            }

            // 跳出循环有两种情况  1.tmp是最小的需要插入到第一个元素 此时j=-1  结束条件是j不>=0了   2.else语句中的break；
            arr[j+1] = tmp;
        }
    }

    private static void midOfThree(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if(arr[left] > arr[right]) swap(arr,left,right);// 保证左边元素是较小值
        if(arr[mid] > arr[right]) swap(arr,mid,right);// 保证中间元素是较小值
        if(arr[mid] > arr[left]) swap(arr,mid,left);// 此时保证left下标的值是中间大小


    }


    private static int parttionHoare(int[] arr,int left,int right) {
        int i = left;
        // 每次都选取第一个元素为基准值
        int key = arr[left];

        // 遍历交换
        // left  从左往右  找比Key大的
        // right 从右往左  找比key小的
        while (left < right) {
            /**
             * 为什么先走右边
             * 先走right保证他们相遇时  一定是比key值小的数据
             * 如果先走left 相遇时碰到的一定是比key大的  此时再交换  则key的左边存在比key大的数据了
             */
            // 先从右边找
            while (left < right && arr[right] >= key) {  // 等号必须要取  万一两个都是6  会陷入死循环
                right--;
            }
            // 此时right下标的元素比key小

            while (left < right && arr[left] <= key) {
                left++;
            }

            swap(arr,left,right);
        }

        // 使基准值位于中间（即左边都比key小  右边都比key大）
        swap(arr,i,left);
        return left;
    }

    // 挖坑法
    private static int parttion2(int[] arr,int left,int right) {
        // 每次都选取第一个元素为基准值
        int key = arr[left];


        // 遍历交换
        // left  从左往右  找比Key大的
        // right 从右往左  找比key小的
        while (left < right) {
            // 先从右边找
            while (left < right && arr[right] >= key) {  // 等号必须要取  万一两个都是6  会陷入死循环
                right--;
            }
            // 此时right下标的元素比key小
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }

        // 使基准值位于中间（即左边都比key小  右边都比key大）
        arr[left] = key;
        return left;
    }

    private static int parttion(int[] arr,int left,int right) {
        // 前后指针法
        int prev = left;
        int cur = left+1;

        while (cur <= right) {
            if(arr[cur] < arr[left] && arr[++prev] != arr[cur]) {
                swap(arr,cur,prev);
            }

            cur++;
        }

        // 遍历完整个数组了
        swap(arr,left,prev);
        return prev;
    }

    /**
     * 快排的优化
     * 1.三数取中法：解决特殊情况 --》第一个数字是最小的  或者是最大的 减少了树的高度  开辟的空间更小
     * 2.小区间内采用插入排序  减少递归的次数（但时间有可能会增加）  降低了内存的要求
     */

    // 快排的非递归写法
    public static void quickSortNor(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = arr.length-1;
        int pivot = parttion(arr,left,right);

        // 保证pivot左边至少有两个数据
        if(pivot-1 > left) {
            stack.push(left);
            stack.push(pivot-1);
        }
        // 保证pivot右边至少有两个数据
        if (pivot + 1 < right) {
            stack.push(pivot+1);
            stack.push(right);
        }

        while(!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();

            pivot = parttion(arr,left,right);

            if(pivot-1 > left) {
                stack.push(left);
                stack.push(pivot-1);
            }

            if (pivot + 1 < right) {
                stack.push(pivot+1);
                stack.push(right);
            }
        }

    }


    /**
     * 归并排序：
     * 时间复杂度：O(n*logN)
     * 空间复杂度：O(N);
     * 稳定
     *
     * 分解左边  分解右边  归并(合并两个有序数组)
     *
     * 稳定的排序：冒泡  插入  归并
     */

    public static void mergeSort(int[] arr) {
        mergeSortFunc(arr,0,arr.length-1);
    }

    private static void mergeSortFunc(int[] arr, int left, int right) {
        if(left >= right) return;

        int mid = (left+right) / 2;
        mergeSortFunc(arr,left,mid);
        mergeSortFunc(arr,mid+1,right);
        merge(arr,left,mid,right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // 这里边的思路相当于是 合并两个有序序列
        int[] tmpArr = new int[right-left+1];
        int k = 0;

        // 分别定义两个需要合并的数组的首元素的下标
        int s1 = left;
        int s2 = mid+1;

        // 遍历两个数组
        while(s1 <= mid && s2 <= right) {
            if(arr[s1] < arr[s2]) {
                tmpArr[k++] = arr[s1++];
            }else {
                tmpArr[k++] = arr[s2++];
            }
        }

        // 出循环证明有一个数组不为空
        while(s1 <= mid) {
            tmpArr[k++] = arr[s1++];
        }

        while (s2 <= right) {
            tmpArr[k++] = arr[s2++];
        }

        // 将排序好的元素返回给原数组
        for (int i = 0; i < tmpArr.length; i++) {
            arr[i+left] = tmpArr[i];
        }
    }

    // 归并排序的非递归写法
    public static void mergeSortNor(int[] arr) {
        int gap = 1;
        while(gap < arr.length) {
            for (int i = 0; i < arr.length; i+= 2*gap) {
                int left = i;
                int mid = i+gap-1;
                int right = mid+gap;

                if(mid >= arr.length) {
                    mid = arr.length-1;
                }
                if(right >= arr.length) {
                    right = arr.length-1;
                }

                merge(arr,left,mid,right);
            }

            gap *= 2;
        }
    }


    /**
     * 计数排序
     * 时间复杂度：O(N+范围）
     * 空间复杂度：O(范围)
     * 稳定性好
     */

    public static void countSort(int[] arr) {
        // 1.得到数组的最大值和最小值（数组的下标只能从0开始）
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }

            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        //2.遍历arr  并在计数数组中存放对应的次数
        int[] count = new int[maxVal - minVal + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - minVal]++;
        }

        //3.重新写入到原数组
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                arr[index] = i + minVal;
                index++;
                count[i]--;
            }
        }
    }

    

}
