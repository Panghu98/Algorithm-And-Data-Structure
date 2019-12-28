package practiceofswordtooffer.question46;

/**
 * @author dengg
 */
public class Solution {


    private int getTranslate(String number) {
        char[] chars = number.toCharArray();
        int[] counts = new int[chars.length];
        int count;
        for (int i = number.length()-1; i >= 0; i--) {

            //动态规划  最后一位数是没有组合的可能的（结果为1）
            if (i < number.length() -1) {
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
                if (converted >= 10 && converted < 25) {
                    //动态规划
                    if (i < number.length() -2) {
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


    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.getTranslate("121");
        System.err.println(count);
    }

}
