import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-15
 * Time: 16:22
 */
class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] arr,int left,int right) {
        while(left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }


}


public class Test {
    public static void main2(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);// true

//        int i11 = 999;
//        int i22 = 999;
//        System.out.println(i11 == i22);
    }

    public static boolean isValid(String s) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            // 获取当前字符
            char ch = s.charAt(i);
            // 左括号
            if(ch == '(' || ch == '{' || ch == '[') {
                list.add(ch);
            }else {// 右括号
                if(list.isEmpty()) {
                   return false;
                }else {
                    // 要进行括号匹配
                    char top = list.get(list.size()-1);

                    if(ch == '}' && top == '{' || ch == ')' && top == '(' ||ch == ']' && top == '[') {
                        list.remove(list.size()-1);
                    }else {
                        return false;
                    }
                }
            }
        }

        return list.isEmpty();

    }

    public static void main22(String[] args) {
        String s = "(])";
        isValid(s);

    }

    static class MinStack {
        //思路1 使用两个栈
        private Stack<Integer> stack;
        private Stack<Integer> minstack;// 存放过程中的最小值

        private int min = Integer.MAX_VALUE;


        public MinStack() {
            this.stack = new Stack<>();
            this.minstack = new Stack<>();
        }


        public void push(int val) {
            if (val <= min) {
                minstack.push(val);
                min = val;
            }

            stack.push(val);

        }

        public void pop() {
            if (stack.peek().equals(minstack.peek())) {
                minstack.pop();
            }

            stack.pop();
        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            if (minstack.isEmpty()) {
                return -1;
            }
            return minstack.peek();
        }

        public void main(String[] args) {
            MinStack minStack = new MinStack();
            minStack.push(512);
            minStack.push(-1024);
            minStack.push(1024);
            minStack.push(512);

            System.out.println(1);
        }
    }



}
