package practiceofswordtooffer.question60;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:11 2020/3/16
 * @Modified By:
 */
public class Solution_Copy2 {

    public void printProbability(int num) {
        // 数组长度为2的二维数组
        int[][] probability = new int[2][];
        int maxValue = 6;
        probability[0] = new int[num*maxValue+1];
        probability[1] = new int[num*maxValue+1];

        int flag = 0;
        // 初始化只有一颗骰子的情况
        for (int i = 1; i <= maxValue; i++) {
            probability[flag][i] = 1;
        }

        for (int k = 2; k <= num ; k++) {
            // 骰子可能值的取值范围为num 到 num * maxValue
            for (int i = num; i <= num * maxValue ; i++) {
                for (int j = 1; j <= maxValue && j < i; j++) {
                    probability[1-flag][i] += probability[flag][i - j];
                }
            }

            flag = 1- flag;
        }

        double total = Math.pow(maxValue, num);
        for (int i = num; i <= maxValue * num; i++) {
            double ratio = (double) probability[flag][i] / total;
            System.out.println(i);
            DecimalFormat df = new DecimalFormat("0.00000000000");
            System.out.println(df.format(ratio));
        }
    }

    @Test
    public void test() {
        printProbability(10);
    }

}
