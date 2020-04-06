package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 779. 第K个语法符号
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 *
 * 例子:
 *
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 *
 * 注意：
 *
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 * @Date: Created in 20:42 2020/4/6
 * @Modified By:
 */
public class LeetCode779 {

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        // 层数叠加结果为奇数
        boolean isLeft = (k + 1) % 2 == 0;

        // 计算序号
        int start = (int) Math.pow(2,n-1) - 1;
        int serialNumber = start+k;
        boolean result = isZero(serialNumber,isLeft);

        if (result) {
            return 0;
        }else {
            return 1;
        }
    }

    /**
     *
     * @param isLeft
     * @return
     */
    private boolean isZero(int serialNumber ,boolean isLeft) {
        if (serialNumber <= 2) {
            return isLeft;
        }
        isLeft = isLeft == ((serialNumber % 2) == 0);
        serialNumber = serialNumber >> 1;
        return isZero(serialNumber,isLeft);
    }


    @Test
    public void test() {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(2,1));
        System.out.println(kthGrammar(2,2));
        System.out.println(kthGrammar(4,5));

    }
    public int kthGrammarNice(int N, int K) {
        if (N == 1) return 0;
        if (K <= 1 << N-2)
            return kthGrammar(N-1, K);
        return kthGrammar(N-1, K - (1 << N-2)) ^ 1;
    }

}
