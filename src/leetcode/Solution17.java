package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengg
 */
public class Solution17 {



    public static List<String> better(String digits) {
        List<String> res = new ArrayList<>();
        String oneRes = "";
        if ("".equals(digits)) {
            return res;
        }
        String[] dict = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        //索引
        int[] digitInt = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            //获得数字
            digitInt[i] = digits.charAt(i) - '0';
        }

        combi(digitInt, 0, dict, res, oneRes);
        return res;
    }

    private static void combi(int[] digits, int n, String[] dict, List<String> res, String oneRes) {
        if (n == digits.length) {
            System.err.println(oneRes);
            res.add(oneRes);
            return;
        }
        for (int j = 0; j < dict[digits[n]].length(); j++) {
            oneRes = oneRes + dict[digits[n]].charAt(j);
            combi(digits, n + 1, dict, res, oneRes);
            // 必要的，在这个循环中如果不截取的话，-1是为了返回上一个字符减一的阶段
            oneRes = oneRes.substring(0, oneRes.length() - 1);
        }
    }

    public static void main(String[] args) {
         better("456");
    }

}
