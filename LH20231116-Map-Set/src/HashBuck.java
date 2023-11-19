/**
 * Created with IntelliJ IDEA.
 * Description:模拟实现哈希表
 * User: 绿字
 * Date: 2023-11-17
 * Time: 15:13
 */

/**
 * 哈希桶是如何解决哈希冲突的呢？
 * 哈希冲突就是在建立映射关系的时候  可能出现一个下标对应多个key的情况  闭散列的解法是使区间足够长 使每个key都有自己唯一的下标
 * 但是这种做法需要开辟的空间太大  不太合理  所以采用闭散列的方法
 * 所谓闭散列  就是哈希桶  使下标存储为一个链表  也就是每个索引下边都是一串链表
 * 但是哈希桶就真的解决问题了么？不是的  在数据量很大的情况下  有可能会出现闭散列的情况  开辟的空间太大
 * 为了避免这种情况的出现  引入了负载因子  来降低冲突率
 * 同时当链表长度 > 8 && 数组长度 > 64 时  会进行调整 调整为红黑树  提升性能  降低冲突率
 */
public class HashBuck {
    // 哈希表实际上一个数组  数组的元素是Node
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] arr;
    public int usedSize;

    public HashBuck() {
        arr = new Node[5];
    }

    public boolean search(int key) {
        int index = key % arr.length;
        Node cur = arr[index];

        while (cur != null) {
            if (cur.key == key) {
                return true;
            }
        }

        return false;
    }

    // put方法
    public void put(int key,int val) {
        int index = key % arr.length;
        Node cur = arr[index];

        // 遍历整个链表 看是否已经存在相同的key值
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }

            cur = cur.next;
        }

        // 头插法  arr[index]其实就是链表的头节点
        Node newNode = new Node(key,val);
        newNode.next = arr[index];
        arr[index] = newNode;
        usedSize++;

        // 判断负载因子此时是否合理
        if(loadFactor() >= 0.75) {
            resize();
        }
    }

    private double loadFactor() {
        return usedSize*1.0 / arr.length;
    }

    private void resize() {
        // 扩大到原来的两倍
        Node[] tmpArr = new Node[arr.length*2];

        // 扩容之后 要进行重新哈希
        for (int i = 0; i <arr.length ; i++) {
            Node cur = arr[i];
            while (cur != null) {
                Node curNext = cur.next;

                int newIndex = cur.key % tmpArr.length;
                // 头插
                cur.next = tmpArr[newIndex];
                tmpArr[newIndex] = cur;

                cur = curNext;
            }
        }

        //数组是对象！！！
        arr = tmpArr;
    }

    // get
    public int get(int key) {
        int index = key % arr.length;
        Node cur = arr[index];

        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }

            cur = cur.next;
        }

        return -1;

    }
}
