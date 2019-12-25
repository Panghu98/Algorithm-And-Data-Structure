package practiceofswordtooffer.question38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author dengg
 */
public class Solution {

    public ArrayList<String> permutation(String str) {

        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        //可以利用set进行去重操作
        Set<String> set = new TreeSet<>();
        helper(str.toCharArray(),0,set);
        return new ArrayList<>(set);
    }


    private static void helper(char[] s, int i, Set<String> set) {
        if (i == s.length) {
            set.add(String.valueOf(s));
        }

        //打乱数组进行存储
        for (int j = i; j < s.length; j++) {
            swap(s, i, j);
            //下一个是字符和剩下的进行交换
            helper(s, i + 1, set);
            //还原位置
            swap(s, i, j);
        }
    }
    public static void swap(char[] s, int i, int j) {
        if (s[i] != s[j]) {
            char temp =s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new Solution().permutation("abc");
        System.err.println(arrayList);
    }

}
