package leetcode;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:05 2021/2/27
 * @Modified By:
 */
public class Leetcode395_2 {

    public static int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) {
            return 0;
        }

        // 因为全是小写字母直接数组对应就OK
        int[] alphabets = new int[26];

        // 统计次数
        for (char c:s.toCharArray()) {
            alphabets[c - 'a']++;
        }

        // 定义一个字符串，用于传入split函数分割当前字符串
        StringBuilder cut = new StringBuilder();
        cut.append("[");

        boolean flag = true;

        for (int i = 0; i < alphabets.length; i++) {
            int count = alphabets[i];
            // 出现了，但是次数少于k(不满足条件的情况)
            if (count < k && count > 0) {
                flag = false;
                cut.append("//");
                cut.append((char)(i + 'a'));
            }
        }

        if (flag) {
            return s.length();
        }

        cut.append("]");


        int res = 0;

        String[] split = s.split(cut.toString());
        for (String s1 : split) {
            // 递归处理子串
            res = Math.max(longestSubstring(s1, k), res);
        }


        return  res;

    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc",2));
    }

}
