package practiceofswordtooffer.question16;

public class Solution1 {

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

    /**
     * 无符号数的次方计算
     * @param base 基数
     * @param exponent 指数
     * @return 次方计算值
     */
    private static double powerWithUnsignedExponent(double base,int exponent) {
        //自身进行了一次次方运算，所以从一开始
        for (int i = 1; i < exponent; i++) {
            base *= base;
        }
        return base;
    }

    public static void main(String[] args) {
        System.err.println(power(2,-2));
    }

}
