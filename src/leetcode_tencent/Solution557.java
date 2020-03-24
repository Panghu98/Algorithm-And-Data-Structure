package leetcode_tencent;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @Date: Created in 20:21 2020/3/24
 * @Modified By:
 */
public class Solution557 {

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) {
                stringBuilder.append(reverse(s,start,s.length()-1));
                break;
            }
            if (s.charAt(i) == ' ') {
                stringBuilder.append(reverse(s,start,i-1));
                stringBuilder.append(" ");
                start = i + 1;
            }
        }
        return stringBuilder.toString();
    }

    private String reverse(String str,int start,int end) {
        StringBuilder reverseString = new StringBuilder();
        for (int i = end; i >= start; i--) {
            reverseString.append(str.charAt(i));
        }
        return reverseString.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseWords( "Let's take LeetCode contest"));
    }
}
