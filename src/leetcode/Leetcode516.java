package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 14:30 2021/2/28
 * @Modified By:
 */
public class Leetcode516 {

    public int longestPalindromeSubseq(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        // 填充数组
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp.length ;j ++) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // 整个 s 的最长回文子串长度
        return dp[0][n - 1];

    }

    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

}
