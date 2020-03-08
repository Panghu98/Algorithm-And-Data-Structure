package test;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 15:57 2020/3/4
 * @Modified By:
 */
public class Offer58 {

    public static String reverseLeftWords(String s, int n) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        char[] chars = s.toCharArray();
        return String.valueOf(chars, n, chars.length-n) +
                String.valueOf(chars, 0, n);
    }

    @Test
    public void test() {
        String s = "abcdefg";
        int k = 2;
        System.err.println(reverseLeftWords(s,2));
    }

}
