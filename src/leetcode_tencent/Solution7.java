package leetcode_tencent;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Date: Created in 21:34 2020/3/24
 * @Modified By:
 *
 *
 */
public class Solution7 {

    // 判断是否为负数的标志位
    boolean isNegative = false;

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String str = convertIntegerToString(x);
        long result = Long.parseLong(str);
        if (result > Integer.MAX_VALUE) {
            return 0;
        }else {
            int num = Math.toIntExact(result);
            if (isNegative) {
                num = -num;
            }
            return num;
        }

    }

    private String convertIntegerToString(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        // 转变为正数
        if (x < 0) {
            x = -x;
            isNegative = true;
        }
        while (x != 0) {
            stringBuilder.append(x%10);
            x = x /10;
        }
        return stringBuilder.toString().replace("-","");
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //2147483647 Integer.MAX_VALUE，注意结束条件的判断
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            // 同理 -2147483648 Integer.MIN_VALUE
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test() {
        System.out.println(reverse2(-2147483648));
    }
}
