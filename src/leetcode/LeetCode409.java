package leetcode;

import map.Map;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:53 2020/3/21
 * @Modified By:
 */
public class LeetCode409 {


    public int longestPalindrome(String s) {
        int oddMax = 0;
        int evenCounter = 0;

        // 存储大写字母的数量
        int[] capArr = new int[26];

        // 存储小写字母的数量
        int[] lowerArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是大写字母数组
            if (c <('a' -1 )) {
                int index = c - 'A';
                capArr[index] += 1;
            }else {
                int index = c -'a';
                lowerArr[index] += 1;
            }
        }

        int size = 0;

        for (int i = 0; i < lowerArr.length; i++) {
            size += lowerArr[i];
            // 如果为偶数
            if (lowerArr[i] != 0) {
                if (lowerArr[i] % 2== 0) {
                    evenCounter += lowerArr[i];
                }else {
                    if (lowerArr[i] > oddMax) {
                        oddMax = lowerArr[i];
                    }
                    evenCounter += lowerArr[i] - 1;
                }
            }
        }

        for (int i = 0; i < capArr.length; i++) {
            // 如果为偶数
            if (capArr[i] != 0) {
                if (capArr[i] % 2 == 0) {
                    evenCounter += capArr[i];
                }else {
                    if (capArr[i] > oddMax) {
                        oddMax = capArr[i];
                    }
                    evenCounter += capArr[i] -1;
                }
            }
        }


        // 多减去了一个奇数的1
        if (oddMax != 0) {
            evenCounter++;
        }
        return evenCounter;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("AB"));
    }

}
