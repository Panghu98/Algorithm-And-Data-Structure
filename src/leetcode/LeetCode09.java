package leetcode;

/**
 * @author: panghu
 * @Description:
 *
 * 输入的是一个数字
 *  1.如果是负数的话就一定不是负数
 *  2.对于回文的判定是中间对称，但是对于数字而言的，因为数字不能直接像字符串一样直接进行判定。
 *
 * @Date: Created in 16:40 2021/1/4
 * @Modified By:
 */
public class LeetCode09 {

    public boolean isPalindrome(int x) {
        // 负数都不是回文
        if(x < 0) {
            return false;
        }

        return reverseNum(x) == x;
    }

    /**
     * 反转数字 - 这里可以优化，只转换一半
     * @return
     */
    private int reverseNum(int num) {

        int total = 0;

        while (num != 0) {
            // 获取尾数 - 转换为头部
            total += num % 10;
            num = num / 10;
            if (num != 0) {
                total *= 10;
            }
        }

        return total;

    }

    public static void main(String[] args) {
        LeetCode09 leetCode09 = new LeetCode09();
        System.out.println(leetCode09.reverseNum(1357));
    }

}
