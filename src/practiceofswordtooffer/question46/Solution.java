package practiceofswordtooffer.question46;

import org.junit.Test;

/**
 * @author dengg
 */
public class Solution {


    private int getTranslate(String number) {
        // 1 2 2 5 8
        char[] chars = number.toCharArray();
        //{5,3,2,1,1}
        int[] counts = new int[chars.length];
        int count;
        for (int i = number.length()-1; i >= 0; i--) {

            //动态规划  最后一位数是没有组合的可能的（结果为1）
            if (i < number.length() -1) {
                //向左递增
                count = counts[i+1];
            }else {
                count =1;
            }

            if (i < number.length() -1) {

                //转换为字符串
                int digit1 = chars[i]-'0';
                int digit2 = chars[i+1]-'0';

                //判断组合字符
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    //动态规划
                    if (i < number.length() -2) {
                        // 这里很奇妙,动态规划的特性
                        // 考虑 爬楼梯问题，一次只能走一格或者两格
                        count += counts[i+2];
                    }else {
                        //该组合是右边界组合则+1
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }
        count = counts[0];
        //帮助GC
        counts = null;
        return count;
    }


    @Test
    public void main() {
        int count = getTranslate("12258");
        System.err.println(count);
    }

}
