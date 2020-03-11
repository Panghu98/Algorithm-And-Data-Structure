package practiceofswordtooffer.question42;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:21 2020/3/11
 * @Modified By:
 */
public class Solution_Copy {

    public int findGreatestSumOfSubArray(int[] arr) {
        int max = arr[0];
        int[] dp = new int[arr.length];

        dp[0] = max;

        for (int i = 1; i < arr.length; i++) {
            int newMax = dp[i-1] + arr[i];
            if (newMax > max) {
                dp[i] = newMax;
                //如果arr[i-1] < 0重新起头
            }else {
                dp[i] = arr[i];
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }
       return max;

    }

}
