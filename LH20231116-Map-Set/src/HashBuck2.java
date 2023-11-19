import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-17
 * Time: 15:14
 */

/**
 * 数据类型是引用类型  即Key是引用
 * 建立引用类Person 与 与 id的映射关系
 */
class Person {
    public String id;

    public Person(String id) {
        this.id = id;
    }

    // 存储的对象是一个一个人  key是一个引用类型  想要将类型转化为整数  并比较大小  重写方法

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
// K,V都是泛型  一定要在类的声明中添加
public class HashBuck2<K,V> {
    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

    public Node<K,V>[] arr;
    public int usedSize;

    public HashBuck2() {
        arr = (Node<K, V>[]) new Node[5];
    }

    // put在hash中插入数据
    public void put(K key, V val) {
        // 先获取对应的hash值
        int hash = key.hashCode();
        int index = hash % arr.length;

        Node<K,V> cur = arr[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }

            cur = cur.next;
        }

        Node<K,V> newNode = new Node<>(key,val);
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
        Node<K,V>[] tmpArr = new Node[arr.length*2];

        // 扩容之后 要进行重新哈希
        for (int i = 0; i <arr.length ; i++) {
            Node cur = arr[i];
            while (cur != null) {
               Node curNext = cur.next;

                int newIndex = cur.key.hashCode() % tmpArr.length;
                // 头插
                cur.next = tmpArr[newIndex];
                tmpArr[newIndex] = cur;

                cur = curNext;
            }
        }

        //数组是对象！！！
        arr = tmpArr;
    }


    // get  根据key获得他的val
    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % arr.length;
        Node<K,V> cur = arr[index];

        while(cur != null) {
            if(cur.key.equals(key)) {
                return cur.val;
            }

            cur = cur.next;
        }

        return null;
    }

}
