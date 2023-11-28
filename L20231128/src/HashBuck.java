/**
 * Created with IntelliJ IDEA.
 * Description:练习重写一遍哈希桶
 * User: 绿字
 * Date: 2023-11-28
 * Time: 11:10
 */

import java.util.Arrays;

/**
 * 哈希桶是闭散列解决哈希冲突的一种实现方式   是一个数组  数组的每个元素是结点  结点的元素是entry
 */
public class HashBuck {
    static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] arr;
    private int usedSize;
    public HashBuck() {
        arr = new Node[5];
    }


    // search
    public boolean search(int key) {
        int index = key % arr.length;
        Node cur = arr[index];

        while(cur != null) {
            if(cur.key == key) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    public void put(int key,int val) {
        int index = key % arr.length;
        Node cur = arr[index];

        // 先检查是否已经存在
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }

            cur = cur.next;
        }

        // 不存在  头插法
        Node newNode = new Node(key,val);
        newNode.next = arr[index];
        arr[index] = newNode;
        this.usedSize++;

        // 检查是否超过负载因子
        if(loadFactor() >= 0.75) {
            resize();
        }
    }

    private double loadFactor()   {return (this.usedSize * 1.0 / arr.length);}

    private void resize() {
        Node[] tmp = Arrays.copyOf(arr,2*arr.length);

        // 重新哈希
        for (int i = 0; i < arr.length; i++) {
            Node cur = arr[i];
            while (cur != null) {
                Node curNext = cur.next;
                int newIndex = cur.key % tmp.length;

                cur.next = tmp[newIndex];
                tmp[newIndex] = cur;

                cur = curNext;

            }


        }

        arr = tmp;
    }

    public int get(int key) {
        int index = key % arr.length;
        Node cur = arr[index];

        while(cur != null) {
            if (cur.key == key) {
                return cur.val;
            }

            cur = cur.next;
        }

        return -1;
    }

}
