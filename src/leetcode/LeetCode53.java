package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: Created in 18:11 2020/5/4
 * @Modified By:
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {

        // 参数判定，略

        int[] dp = new int[nums.length];

        int maxSum = nums[0];
        dp[0] = maxSum;
        for (int i = 1; i < nums.length; i++) {
            if (maxSum > 0) {
                maxSum += nums[i];
            }else {
                maxSum = nums[i];
            }

            dp[i] = Math.max(maxSum, dp[i - 1]);
        }

        return dp[nums.length-1];

    }

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
