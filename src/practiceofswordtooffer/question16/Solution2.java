package practiceofswordtooffer.question16;

public class Solution2 {

    /**
     * 次方计算
     * @param base 基数
     * @param exponent 指数
     * @return 次方计算结果
     */
    public static double power(double base,int exponent) {
        if (base == 0) {
            if (exponent < 0) {
                throw new IllegalArgumentException("基数为0是，指数不能为负数");
            }
            return 0;
            //避免for循环计算
        }else if (exponent == 1) {
            return base;
        }

        double tempResult = powerWithUnsignedExponent(base, Math.abs(exponent));
        if (exponent < 0) {
            tempResult = 1/tempResult;
        }
        return tempResult;
    }

    private static int counter = 0;

    /**
     * 无符号数的次方计算
     * @param base 基数
     * @param exponent 指数
     * @return 次方计算值
     */
    private static double powerWithUnsignedExponent(double base,int exponent) {

        counter ++;

        //终点判断，次方位移到1
        if (exponent == 1) {
            return base;
        }
        double result = powerWithUnsignedExponent(base,exponent>>1);
        result *= result;
        //判断奇偶性，利用位移的效率比%高，如果是奇数需要多乘上一个base，因为奇数位移的时候，exponent少了一
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.err.println(powerWithUnsignedExponent(2,11));
    }

}
