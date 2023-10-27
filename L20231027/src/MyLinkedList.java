/**
 * Created with IntelliJ IDEA.
 * Description:无头双向非循环链表实现  也就是Java中LInkedList的内部实现方式
 * 15.53 -- 16.07
 * User: 绿字
 * Date: 2023-10-27
 * Time: 15:50
 */
public class MyLinkedList {
    static class ListNode {
        int data;
        ListNode prev;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode head;
    public ListNode last;

    public int size() {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }

        return cnt;
    }

    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    // addFirst
    public void addFirst(int data) {
        ListNode node = new ListNode(data);

        if (head == null) {
            head = last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);

        if (last == null) {
            head = last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    public void add(int pos,int data) {
        if (pos < 0 || pos > size()) {
            throw new PosOutOfBoundException("位置异常");
        }

        if (pos == 0) {
            addFirst(data);
            return;
        }

        if (pos == size()) {
            addLast(data);
            return;
        }

        ListNode node = new ListNode(data);
        ListNode cur = head;
        while (pos > 0) {
            cur = cur.next;
            pos--;
        }

        node.next = cur;
        cur.prev.next = node;

        node.prev = cur.prev;
        cur.prev = node;
    }

    public void remove(int key) {

        ListNode cur = head;
        while (cur != null) {
            if (cur.data == key) {
                // 头节点单独处理
                if (cur == head) {
                    head = head.next;
                    if (head == null) {
                        last = null;
                    }else {
                        head.prev = null;
                    }
                }else {// 处理中间节点和尾结点
                    if (cur.next == null) {
                        // 尾结点
                        last.prev.next = null;
                        last = last.prev;
                    }else {
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                }
                cur = cur.next;
                return;

            }else {
                cur = cur.next;
            }
        }

    }



    public void removeAll(int key) {

        ListNode cur = head;
        while (cur != null) {
            if (cur.data == key) {
                // 头节点单独处理
                if (cur == head) {
                    head = head.next;
                    if (head == null) {
                        last = null;
                    }else {
                        head.prev = null;
                    }
                }else {// 处理中间节点和尾结点
                    if (cur.next == null) {
                        // 尾结点
                        last.prev.next = null;
                        last = last.prev;
                    }else {
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                }
                cur = cur.next;

                //return;

            }else {
                cur = cur.next;
            }
        }

    }
}
