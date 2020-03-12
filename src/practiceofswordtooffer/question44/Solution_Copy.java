package practiceofswordtooffer.question44;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:26 2020/3/12
 * @Modified By:
 */
public class Solution_Copy {

    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            // 范围值
            int num = getNums(digits);
            if (num < index) {
               return   digitAtIndex(index,digits);
            }else {
                digits++;
                //index减去之后可能等于0
                index -= num;
            }
        }
    }

    //digits位数的第一个数字，两位数从10开始，三位数从100开始
    private int beginNumberFor(int digits)
    {
        if (digits == 1) {
            return 0;
        }

        return (int) Math.pow(10, digits - 1);
    }

    private int digitAtIndex(int index, int digits) {
        //对应的数值
        //beginNumberFor用于获取数位对应的起始数字
        int number = beginNumberFor(digits) + index / digits;
        //从数值右边开始算的位置
        int indexFromRight = digits - index % digits;
        //去除右边的indexFromRight-1个数字
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        //求个位数字
        return number % 10;
    }

    /**
     * 获取区间大小 1 * 9，2 * 90 ，3 * 900,4 * 90000 . 注意越界问题。
     * @param num
     * @return
     */
    private int getNums(int num) {
        if (num == 1) {
            return 10;
        }
        int result = num * 9;
        while (num > 1) {
            result *= 10;
            num--;
        }
        return result;
    }

    @Test
    public void test() {
        System.err.println(getNums(3));
    }

}
