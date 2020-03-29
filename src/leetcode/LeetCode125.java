package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 17:26 2020/3/29
 * @Modified By:
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }



         s = s.toLowerCase();

        int end = s.length() - 1;
        int start = 0;

        while (start < end) {
            while (!validRange(s.charAt(start))) {
                start++;
                if (start >= end) {
                    return true;
                }
            }

            while (!validRange(s.charAt(end))) {
                end--;
                if (start >= end) {
                    return true;
                }
            }
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    private boolean validRange(char ch) {
        return (ch>= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }


    @Test
    public void test() {
        System.out.println(isPalindrome("0p"));
    }

}
