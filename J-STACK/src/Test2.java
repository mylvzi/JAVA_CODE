import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:stack的模拟实现
 * User: 绿字
 * Date: 2023-10-19
 * Time: 21:01
 */
public class Test2 {
    public static void main2(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack);

        System.out.println(myStack.pop());

        System.out.println(myStack);

        System.out.println(myStack.peek());

        System.out.println(myStack);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    public static void main(String[] args) {
        isValid("()[]{}");
    }

    public static boolean isValid(String s) {
        // 将左括号存到一个栈中  遇到右括号就pop  看是否匹配
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            // 得到当前字符串所对应的字符
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                // 左括号  入栈
                stack.push(ch);

            }else {
                // 右括号
                if(stack.empty()) {// 栈内没有左括号  字符串的第一个字符就是一个右括号
                    return false;
                }else {
                    // 不为空就要判断是否匹配
                    char top = stack.peek();

                    // top是左括号  ch是右括号
                    if(ch == ')' && top == '(' || ch == ']' && top == '[' || ch == '{' && top == '}') {
                        stack.pop();
                    }else {
                        // 不匹配直接返回false
                        return false;
                    }

                }
            }
        }

        // if(!stack.empty()) {
        //     // 栈不为空  就证明栈内还有元素未匹配  数量不匹配
        //     return false;
        // }

        // return true;

        return stack.empty();


    }
}
