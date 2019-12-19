package practiceofswordtooffer.question31;

import java.util.Stack;

/**
 * @author dengg
 *
 * 通过辅助栈实现，主要根据弹出栈进行判断
 */
public class Solution {
    public boolean isPopOrder(int [] pushA,int [] popA) {


        if(pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int value : pushA) {
            s.push(value);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }
}
