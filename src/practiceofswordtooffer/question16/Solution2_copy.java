package practiceofswordtooffer.question16;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:34 2020/3/8
 * @Modified By:
 */
public class Solution2_copy {

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

    private static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        boolean isOddExponent = (exponent & 1) == 1;
        double result;
        result = powerWithUnsignedExponent(base,exponent/2) ;
        result *= result;
        if (isOddExponent) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.err.println(powerWithUnsignedExponent(2,11));
    }


}
