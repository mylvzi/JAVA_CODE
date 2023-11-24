/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-24
 * Time: 22:22
 */
public class MyLinkedList {

    static class ListNode {
        private int data;
        private ListNode prev;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode head;
    public ListNode last;

    /**
     * 前三个方法和prev没关系
     * 只需遍历整个链表即可
     * @return
     */

    //得到单链表的长度
    public int size(){
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }

        return cnt;
    }

    // 打印链表
    public void display(){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }

        System.out.println("链表不包含该元素");
        return false;
    }


    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);

        // 为空，直接赋值
        if (head == null) {
            head = last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }

    }

    //尾插法  最方便的一集  因为本来就有尾结点
    public void addLast(int data){
        ListNode node = new ListNode(data);

        // 为空，直接赋值
        if (head == null) {
            head = last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }


    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index<0 || index>size()) {
            throw new RuntimeException(index + "位置异常");
        }

        if (index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }

        ListNode cur = searchIndex(index);
        ListNode node  = new ListNode(data);


        // 插入  对于单链表来说需要cur走到Index位置的前一个结点  而双向链表不需要  直接走到index位置的结点即可
        // 在index位置的插入都是先绑定后面的
        node.next = cur;
        cur.prev.next = node;

        // 这两行的顺序不能改变
        node.prev = cur.prev;
        cur.prev = node;

    }

    private ListNode searchIndex(int index) {
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }

        return cur;
    }


    /**
     * 我写的这个删除的代码将寻找data==Key的这个过程封装成一个方法  思路很好  但是不利于写删除所有的key值的方法
     * 因为想要删除所有的key值，不可避免的是要遍历整个链表，而不是得到某一个节点
     * @param key
     * @return
     */


/*    //删除第一次出现关键字为key的节点
    public void remove(int key){
        // 不能这样写，因为要求的是删除第一次出现的key

//        if(last.data == key) {
//            last = last.prev;
//            last.next = null;
//            return;
//        }
        // 使cur为data为key的结点
        ListNode cur = findIndexOf(key);
        if (cur == null) {
            System.out.println("没有你要删除的结点");
            return;
        }

        if (cur == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }else {
                // 处理只有一个结点的情况  head直接为空了  此时只需把last也置空即可
                last = null;
            }
        }else {
            // 处理中间结点和尾巴结点  尾巴结点要单独处理（后继为null）
            if (cur.next != null) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }else {
                cur.prev.next = null;
                last = cur.prev;
            }

        }
    }

    private ListNode findIndexOf(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.data == key) {
                return cur;
            }

            cur = cur.next;
        }

        return null;
    }*/

    /**
     * 重写remove方法
     * @param key
     * @return
     */

    public void remove(int key) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.data == key) {
                // 等于key也要分两种情况
                if (cur == head) {
                    head = head.next;
                    if (head == null) {
                        last = null;
                    }else {
                        head.prev = null;
                    }
                }else {
                    // 处理中间结点和尾结点
                    if (cur.next != null) {
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else {
                        cur.prev.next = null;
                        last = cur.prev;
                    }
                }

                return;
            }else {
                cur = cur.next;
            }
        }

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = head;

        while (cur != null) {
            if (cur.data == key) {
                // 等于key也要分两种情况
                if (cur == head) {
                    head = head.next;
                    if (head == null) {
                        last = null;
                    }else {
                        head.prev = null;
                    }
                }else {
                    // 处理中间结点和尾结点
                    if (cur.next != null) {
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else {
                        cur.prev.next = null;
                        last = cur.prev;
                    }
                }
                cur = cur.next;

                //return;
            }else {
                cur = cur.next;
            }
        }

    }

    public void clear(){
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;

            cur.prev = null;
            cur.next = null;

            cur = cur.next;
        }

        // 头尾结点要单独置空
        head = null;
        last = null;





//        // 把每一个链表都指控
//        ListNode cur = head;
//        while (cur != null) {
//            cur.prev = null;
//            cur = cur.next;
//            if (cur != null) {
//                cur.prev.next = null;
//            }
//        }
    }

}
