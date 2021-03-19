package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 12:41 2021/3/9
 * @Modified By:
 */
public class Leetcode1047 {

    public String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    public String removeDuplicates2(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates2("abbacb"));
    }

}
