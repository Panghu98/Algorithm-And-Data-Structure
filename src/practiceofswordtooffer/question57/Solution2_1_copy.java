package practiceofswordtooffer.question57;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:46 2020/3/7
 * @Modified By:
 */
public class Solution2_1_copy {
    public void FindContinuousSequence(int num) {
        int small = 1;
        int big = 2;
        int curSum = 3;
        int middle = num/2 +1;
        while (small < middle) {
            if (curSum == num) {
                PrintContinuousSequence(small,big);
            }

            while (curSum < num && big > small) {
                big++;
                curSum += big;
                if (curSum == num) {
                    PrintContinuousSequence(small,big);
                }
            }
            curSum -= small;
            small++;
        }
    }

    private static void PrintContinuousSequence(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        FindContinuousSequence(15);
    }
}
