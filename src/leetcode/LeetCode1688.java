package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:02 2021/1/12
 * @Modified By:
 */
public class LeetCode1688 {

    private int count = 0;

    public int numberOfMatches(int n) {
        // 清除计数
        count = 0;
        doNumberOfMatches(n);
        return count;
    }

    private void doNumberOfMatches(int n) {

        // 胜出队伍
        if (n == 1) {
            return;
        }

        // 胜出队伍
        int promotion;

        int matchCount = n / 2;
        this.count += matchCount;
        // 奇数个
        if ( !isOdd(n)) {
            promotion = (n - 1) / 2 + 1;
        }else {
            promotion = n / 2;
        }
        doNumberOfMatches(promotion);
    }

    /**
     * 判断是不是偶数
     * @param n
     * @return
     */
    public boolean isOdd(int n) {
        return n % 2 == 0;
    }

    @Test
    public void test() {
        System.out.println(numberOfMatches(7));
        System.out.println(numberOfMatches(14));
    }

}
