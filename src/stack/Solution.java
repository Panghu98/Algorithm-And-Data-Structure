package stack;
import array.Array;

import java.util.Stack;

/**
 * @author panghu
 * @title: Solution
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-6 上午8:36
 */
class Solution {
    public boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar  = stack.pop();
                //循环遍历 查看栈顶元素
                //栈栈顶遇到的第一个括号符号  需要是对应的反括号符号,这样才能返回true
                if (c==')' && topChar!='('){
                    return false;
                }
                if (c==']' && topChar!='['){
                    return false;
                }
                if (c=='}' && topChar!='{'){
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[()]"));
    }
}