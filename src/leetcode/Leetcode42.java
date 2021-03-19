package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.Stack;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:28 2021/3/17
 * @Modified By:
 */
public class Leetcode42 {

    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int water = 0;
        //特殊情况
        if(height.length <3){
            return 0;
        }
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                //栈顶元素
                int popnum = stack.pop();
                //相同元素的情况  例1，1
                while(!stack.isEmpty()&& height[popnum] == height[stack.peek()]){
                    stack.pop();
                }
                //计算该层的水的单位
                if(!stack.isEmpty()){
                    int temp = height[stack.peek()];//栈顶元素值
                    //高
                    int hig = Math.min(temp-height[popnum],height[i]-height[popnum]);
                    //宽
                    int wid = i-stack.peek()-1;
                    water +=hig * wid;
                }

            }
            //这里入栈的是索引
            stack.push(i);
        }
        return water;
    }

    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);//找到最大的高度，以便遍历。

        for (int i = 1; i <= max; i++) {
            boolean start = false;

            int tempSum = 0;

            for (int j = 0; j < height.length; j++) {
                if (start && height[j] < i) {
                    tempSum++;
                }

                // 每次遇到高的就做为新的起点
                if (height[j] >= i) {
                    start = true;
                    sum += tempSum;
                    tempSum = 0;

                }

            }
        }

        return sum;
    }
    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }


    @Test
    public void test() {
        int[] ints = {4,3,2,0,1,1,5};
        System.out.println(trap2(ints));
    }

}
