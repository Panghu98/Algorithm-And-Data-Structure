package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: Created in 22:07 2020/4/7
 * @Modified By:
 */
public class LeetCode322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < dp.length) {
                dp[coins[i]] = 1;
            }
        }

        for (int i = 1; i <= amount ; i++) {
            int minKey = minSubKey(dp,coins,i);
            if (minKey != -1) {
                dp[i] = minKey;
            }else {
                dp[i] = -1;
            }
        }

        return dp[amount] == 0 ? -1:dp[amount];
    }

    private int minSubKey(int[] dp,int[] coins,int key) {
        int minTimes = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (key-coins[i] > 0) {
                int value = dp[key-coins[i]];
                if (value != 0 && value < minTimes) {
                    minTimes = value;
                }
            } else if (key == coins[i]) {
                return 1;
            }
        }

        if (minTimes != Integer.MAX_VALUE) {
            return minTimes+1;
        }

        return -1;
    }
    @Test
    public void test() {
        int value = coinChange(new int[]{1,2,5},18);
        System.err.println(value);
    }


}
