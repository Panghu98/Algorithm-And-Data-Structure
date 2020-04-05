package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *
 *  输入：A = 1, B = 10
 *  输出：10
 * 示例2:
 *
 *  输入：A = 3, B = 4
 *  输出：12
 * 提示:
 *
 * 保证乘法范围不会溢出
 * @Date: Created in 21:53 2020/4/5
 * @Modified By:
 */
public class LeetCode_08_05 {

    public int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int min = Math.abs(a),max = Math.abs(b);
        if (min > max) {
            min = b;
            max = a;
        }

        boolean negative = a < 0 ^ b < 0;
        int result = getMultiply(min,max,0);
        if (negative) {
            return -result;
        }else {
            return result;
        }
    }

    private int getMultiply(int min,int max,int result) {
        if (min >= 2) {
            result += max << 1;
            return getMultiply(min-2, max, result);
        }if (min == 0) {
            return result;
        }else {
            return result + max;
        }
    }

    @Test
    public void test() {
        System.out.println(multiply(-12,-12));
    }
}
