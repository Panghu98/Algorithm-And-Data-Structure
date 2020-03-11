package practiceofswordtooffer.question31;

import org.junit.Test;

import java.util.Stack;

/**
 * @author dengg
 *
 * 通过辅助栈实现，主要根据弹出栈进行判断
 *
 * 这道题还是很简单的，利用辅助栈还原数组
 */
public class Solution {
    public boolean isPopOrder(int [] pushA,int [] popA) {


        if(pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        //用于标识弹出序列的位置

        //假设是正常入栈（一个进，一个出）每次进去就出来
        int popIndex = 0;
        for (int value : pushA) {
            s.push(value);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位  移动出栈数组的指针
                popIndex++;
            }
        }
        return s.empty();
    }

    @Test
    public void  test() {
        isPopOrder(new int[]{1,2,3,4,5},new int[]{2,1,3,4,5});
    }
}
