package practiceofswordtooffer.question48;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:54 2020/3/13
 * @Modified By:
 */
public class Solution_Copy {

    public int maxNonRepetitiveString(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] chars = str.toCharArray();
        //动态规划数组
        int[] dp = new int[chars.length];
        dp[0] = 1;
        //不重复字符串的起始位置
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[index]) {
                int length = i - index + 1;
                if (length >= dp[i]){
                    dp[i] = length;
                }
            }else {
                index = i;
                dp[i] = dp[i -1];
            }
        }

        return dp[chars.length-1];

    }

    @Test
    public  void test(){
        System.out.println(maxNonRepetitiveString("arabcacfr"));
        System.out.println(maxNonRepetitiveString("abcdefaaa"));

    }

}
