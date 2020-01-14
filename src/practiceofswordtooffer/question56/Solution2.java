package practiceofswordtooffer.question56;

public class Solution2 {

    public int findNumberAppearingONce(int[] number) {

        if (number == null || number.length == 0) {
            throw new IllegalArgumentException();
        }

        //数组存储的是每一位（数位）数字
        int[] bitSum = {0};
        for (int i = 0; i < number.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0 ; j--) {
                int bit = number[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask <<= 1;
            }
        }

        //如果数位的某一位不能被3整除则该数位包含只出现一次的数字
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] %3;
        }

        return result;
    }

}
