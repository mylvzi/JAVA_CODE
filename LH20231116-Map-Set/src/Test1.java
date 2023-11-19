/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-16
 * Time: 20:48
 */
public class Test1 {
    public static void main(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1,"lvzi");

        // 输出相同的结果  因为Person中重写了equals和hashcode方法  只要内容相同 就认为他们是相同的且具有相同的hashcode值
        // get方法就是根据hashcode方法得到hashcode
        System.out.println(hashBuck2.get(person1));// 输出lvzi

        System.out.println(hashBuck2.get(person2));// 输出lvzi
    }
    public static void main22(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(2,2);
        hashBuck.put(3,3);
        hashBuck.put(4,4);
        hashBuck.put(5,5);
        hashBuck.put(25,25);
        hashBuck.put(35,35);
        hashBuck.put(111,111);

        System.out.println(1);
    }
    public static void main11(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(8);
        binarySearchTree.insert(5);

        binarySearchTree.remove(6);

        System.out.println("==");
    }
}
