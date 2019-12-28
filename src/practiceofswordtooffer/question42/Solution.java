package practiceofswordtooffer.question42;

/**
 * @author dengg
 *
 *  //TODO 不是很明白为什么这么做
 */
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
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
                //相加的值小于当前元素的值
                dp[i] = array[i];
            }

            //最大值发生改变的时候
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

}
