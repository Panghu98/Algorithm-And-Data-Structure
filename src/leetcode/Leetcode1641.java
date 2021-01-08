package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 11:55 2021/1/8
 * @Modified By:
 */
public class Leetcode1641 {

    public int countVowelStrings(int n) {
        int a = 1,e = 1,i = 1,o = 1,u = 1;
        for (int j = 2; j <= n; j++) {
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
//            u = u;
        }

        return a + e + i + o + u;
    }

    @Test
    public void test() {
        System.out.println(countVowelStrings(3));
    }

}
