package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * 516. 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * @Date: Created in 21:53 2020/3/21
 *
 *
 * @Modified By:
 */
public class LeetCode516 {
    public int longestCommonSubsequence(String text1, String text2) {
        // 动态规划数组
//        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    @Test
    public void test() {
        String str1 = "bace";
        String str2 = "dbrabcef";
        System.out.println(longestCommonSubsequence(str1,str2));
    }
}
