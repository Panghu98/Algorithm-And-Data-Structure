package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:14 2020/3/18
 * @Modified By:
 */
public class LeetCode1009 {
    public int findComplement(int num) {
        return getDigit(num)^num;
    }

    public int getDigit(int num) {
        int result = 1;
        while (result <= num) {
            if (result - 1 == Integer.MAX_VALUE /2) {
                return Integer.MAX_VALUE;
            }
            result = result << 1;
        }
        return result-1;

    }

    @Test
    public void test() {
        int result = findComplement(1);
        System.out.println(result);
    }
}
