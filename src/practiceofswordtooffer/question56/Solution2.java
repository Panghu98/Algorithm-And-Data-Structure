package practiceofswordtooffer.question56;

import org.junit.Test;

public class Solution2 {

    public int findNumberAppearingONce(int[] number) {

        if (number == null || number.length == 0) {
            throw new IllegalArgumentException();
        }

        //数组存储的是每一位（数位）数字
        int[] bitSum = new int[32];
        for (int i = 0; i < number.length; i++) {
            int bitMask = 1;
            //从高位到低位计算
            for (int j = 0; j <= 32 ; j++) {
                //利用辅助数组进行数位存储
                int bit = number[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask <<= 1;
            }
        }

        // 数组的和为{7,7,7} 位除以3的结果为{1,1,1}
        //如果数位的某一位不能被3整除则该数位包含只出现一次的数字
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] %3;
        }

        return result;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1,2,3,4,5,6,6,5,4,3,2,1,7,1,2,3,4,5,6};
        System.out.println(findNumberAppearingONce(arr));
    }

}
