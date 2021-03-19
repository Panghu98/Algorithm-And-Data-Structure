package leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 23:29 2021/3/17
 * @Modified By:
 */
public class Leetcode42A {

    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        int length = height.length;
        for (int i = 0; i < length; i++) {

            // 这个是计算有能存放雨水的，如果单调直接push
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int popnum = stack.pop();


                // 相同 - 继续pop
                while (!stack.isEmpty() && height[popnum] == height[stack.peek()]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    int temp = height[stack.peek()];
                    int wight =i - stack.peek() -1;
                    int high = Math.min(height[i] - height[popnum],temp - height[popnum]);
                    sum += wight * high;
                }
            }

            stack.push(i);

        }

        return sum;
    }

    @Test
    public void test() {

        int[] ints = {4,3,2,0,1,1,5};

        System.out.println(trap(ints));


    }

}