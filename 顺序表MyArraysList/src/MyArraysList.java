/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-24
 * Time: 22:26
 */
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-12
 * Time: 8:53
 */
import java.util.*;
/**
 * 顺序表详解
 */
public class MyArrayList {
    private int[] elem;// 存放数据的数组
    private int usedSize;// 有效数据个数

    public static final int DEFAULT_SIZE = 10;

    // 初始化顺序表
    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    public MyArrayList(int ininCapacity) {
        // 自定义数组的大小
        this.elem = new int[ininCapacity];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i] +" ");
        }
    }

    // 添加数据  默认是在末尾添加
    public void add(int data) {
        // 满了要扩容
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        this.elem[usedSize] = data;
        this.usedSize++;
    }

    // 判断是否已满
    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }

        return false;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        // pos位置要合法
        if(pos<0 || pos>this.usedSize) {
            throw new RuntimeException(pos+"位置不合法");
        }

        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        for (int i = this.usedSize-1; i >=pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }

        this.elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        System.out.println("数组不包含该元素");
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        System.out.println("数组不包含该元素");
        return -1;
    }

    // 检查pos位置是否合法
    private void checkPosLegal(int pos) {
        if(pos<0 || pos>=this.usedSize) {
            throw new posOutOfBoundException(pos+" 位置不合法");
        }


    }

    // 获取 pos 位置的元素
    public int get(int pos) {

        checkPosLegal(pos);
        return this.elem[pos];

    }

    // 给 pos 位置的元素设为 value  pos位置必须含有元素
    public void set(int pos, int value) {
        checkPosLegal(pos);
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = indexOf(toRemove);

        for (int i = index; i <this.usedSize-1 ; i++) {
            this.elem[i] = this.elem[i+1];
        }

        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        // 如果是引用类型所有的引用都要置空
//        for (int i = 0; i <this.usedSize; i++) {
//            this.elem[i] = null;
//        }
        this.usedSize = 0;
    }
}

