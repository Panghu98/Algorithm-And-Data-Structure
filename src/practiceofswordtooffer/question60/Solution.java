package practiceofswordtooffer.question60;

import org.junit.Test;

import java.text.DecimalFormat;

public class Solution {
    /*
     * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s,输入n,打印出s的所有可能出现的概率
     */
    public void printProbability(int number) {
        if (number == 1) {
            return;
        }

        //骰子能够产生的最大数字
        int maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[maxValue * number + 1];
        probabilities[1] = new int[maxValue * number + 1];

        int  flag = 0;
        for (int i = 1; i <= maxValue; i++) {
            probabilities[0][i] = 1;
        }

        for (int k = 2; k < number; k++) {
            for (int i = 0; i < k; i++) {
                probabilities[1-flag][i] = 0;
            }

            for (int i = k; i <= maxValue * k; ++i) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; ++j) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;

        }

        double total = Math.pow(maxValue, number);
        for (int i = number; i <= maxValue * number; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(i);
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(ratio));
        }

    }

    @Test
    public void test() {
        printProbability(5);
    }

}
