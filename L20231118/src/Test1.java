import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-18
 * Time: 19:57
 */
public class Test1 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("lvzi");
        set.add("biandu");
        set.add("zhizi");

        System.out.println(set);// 输出[biandu, lvzi, zhizi]
    }
    public static void main2(String[] args) {
        // 根据实现Map的类TreeMap来实例化一个对象
        Map<String,Integer> map = new TreeMap<>();

        // Put方法
        // 设置  单词--出现的次数  这样的一个key与value的映射
        map.put("apple",14);
        map.put("bank",15);
        map.put("cat",17);

//        System.out.println(map.get("apple"));// 输出14
//        System.out.println(map.get("bank"));// 输出15
//        System.out.println(map.get("cat"));// 输出17
//
//        // get时进行判断 如果Map中含有传入的key就返回其value  没有则返回其默认值(解某些题很有用)
//        System.out.println(map.getOrDefault("apple", 100));// 输出14  因为Map中含有apple
//        System.out.println(map.getOrDefault("Dog", 100));// 输出100  因为Map中不含有Dog

//        map.remove("cat");
//        map.remove("Dog");

        // remove存在返回值！！！  返回你要删除的key对应的value
//        public V remove(Object key) {
//            TreeMap.Entry<K,V> p = getEntry(key);
//            if (p == null)
//                return null;
//
//            V oldValue = p.value;
//            deleteEntry(p);
//            return oldValue;
//        }
//
//        System.out.println(map.remove("cat"));// 输出17
//        System.out.println(map.remove("Dog"));// 输出null

//        System.out.println(map.containsKey("cat"));// 输出true
//        System.out.println(map.containsKey("Dog"));// 输出false
//
//        System.out.println(map.containsValue(15));// 输出true
//        System.out.println(map.containsValue(100));// 输出false

//        // get也可以用来判断是否包含相应的key
//        public V get(Object key) {
//            TreeMap.Entry<K,V> p = getEntry(key);
//            return (p==null ? null : p.value);
//        }

        // 此处Set里面存放的类型要和key一致！！！
//        Set<String> set = map.keySet();
//        for (String s:set) {
//            System.out.print(s + " ");// 输出apple bank cat
//        }

//       Collection<Integer> collection = map.values();
//        for (int val:collection) {
//            System.out.print(val + " ");// 输出14 15 17
//        }


//        System.out.println("===");

//        Set<Map.Entry<String,Integer>> set = map.entrySet();
//        for (Map.Entry<String,Integer> entry:set) {
//            System.out.println("key = " + entry.getKey() + " " +"value = " + entry.getValue());
//        }
//
//        // 也可以直接打印
//        System.out.println(set); // 输出[apple=14, bank=15, cat=17]
    }
}
