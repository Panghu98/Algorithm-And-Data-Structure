package leetcode_tencent;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 8:35 2020/3/26
 * @Modified By:
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                // r - l <= 2 左右的距离小于2，这种条件表明相邻，不用计算left和right中间的情况，中间的情况一定是回文
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("ababad"));
    }
}
