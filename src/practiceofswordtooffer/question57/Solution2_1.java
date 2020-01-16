package practiceofswordtooffer.question57;

public class Solution2_1 {
    public void FindContinuousSequence(int sum) {

        if (sum < 3) {
            return;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) /2;
        int curSum = small + big;

        while (curSum < middle) {
            if (curSum == sum ) {
                PrintContinuousSequence(small,big);
            }

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

    private void PrintContinuousSequence(int small, int big) {
        for (int i = small; i < big; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
