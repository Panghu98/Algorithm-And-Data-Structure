package practiceofswordtooffer.question57;

import org.junit.Test;

public class Solution2_1 {
    public static void FindContinuousSequence(int sum) {

        if (sum < 3) {
            return;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) /2;
        //当前总和
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum ) {
                PrintContinuousSequence(small,big);
            }

            //先使用big增加到大于sum
            while (curSum > sum && small < middle) {
                curSum -= small;
                small ++;

                if (curSum == sum) {
                    PrintContinuousSequence(small,big);
                }
            }

            big ++;
            curSum += big;
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
