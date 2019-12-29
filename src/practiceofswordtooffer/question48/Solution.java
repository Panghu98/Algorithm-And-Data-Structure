package practiceofswordtooffer.question48;

/**
 * @author dengg
 */
public class Solution {

    public static int maxNonRepetitiveString(String str) {

        //参数验证
        if (str == null || str.length() == 0) {
            return 0;
        }

        //dp数组可以省略，因为只需记录前一位置的dp值即可
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int maxdp = 1;

        for(int dpIndex = 1;dpIndex<dp.length;dpIndex++){
            //i最终会停在重复字符或者-1的位置,要注意i的结束条件
            int i = dpIndex-1;

            //检测重复的字符 当前的位置到（当前位置-dp[dpIndex-1]）
            for(;i>=dpIndex-dp[dpIndex-1];i--){
                if(str.charAt(dpIndex)==str.charAt(i)) {
                    break;
                }
            }
            dp[dpIndex] =  dpIndex - i;
            //替换最大值
            if(dp[dpIndex]>maxdp) {
                maxdp = dp[dpIndex];
            }
        }
        return maxdp;

    }

    public static void main(String[] args){
        System.out.println(maxNonRepetitiveString("arabcacfr"));
        System.out.println(maxNonRepetitiveString("abcdefaaa"));

    }

}
