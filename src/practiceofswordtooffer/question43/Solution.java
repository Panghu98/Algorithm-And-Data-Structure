package practiceofswordtooffer.question43;

import org.junit.Test;

/**
 * @author dengg
 *
 * 利用排列组合的思想
 */
public class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i,b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }

    @Test
    public void test() {
        System.err.println(NumberOf1Between1AndN_Solution(99));
    }

}
