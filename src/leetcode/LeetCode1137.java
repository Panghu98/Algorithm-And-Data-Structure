package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: Created in 10:50 2020/6/2
 *
 * @Modified By:
 */
public class LeetCode1137 {

    /**
     *  0 : 0
     *  1 : 1
     *  2 : 1 + 0
     *  3 : 1 + 1 + 0
     *  4 : 1 + 1 +1 + 1 + 0
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 1 || n == 2) {
            return  1;
        }

        if (n == 0) {
            return 0;
        }

        return tribonacci(n -1) + tribonacci(n -2) +tribonacci(n - 3);

    }

    @Test
    public void test() {
            System.out.println(tribonacci(25));
    }

}
