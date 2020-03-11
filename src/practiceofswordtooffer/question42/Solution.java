package practiceofswordtooffer.question42;

import org.junit.Test;

/**
 * @author dengg
 *
 *  `
 */
public class Solution {

    public int findGreatestSumOfSubArray(int[] array) {
        int length = array.length;
        int[] dp = new int[length];

        //用于存储最大值
        int max = array[0];

        dp[0] = array[0];
        for (int i = 1; i < length; i++) {
            int newMax = dp[i-1] + array[i];
            if (newMax > array[i]) {
                //相加的值大于当前元素的值
                dp[i] = newMax;
            }else {
                //相加的值小于当前元素的值 -- 前面的数值和小于0
                dp[i] = array[i];
            }

            //最大值发生改变的时候
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    @Test
    public void test() {
        int[] arr = {1,-1,2,-2,3,4,-3,4,-5};
        int result = findGreatestSumOfSubArray(arr);
        System.out.println(result);
    }

}
