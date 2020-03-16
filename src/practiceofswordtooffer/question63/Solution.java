package practiceofswordtooffer.question63;

/**
 * 解法描述：假设diff(i)为当前卖出价的最大利润，就找前面的最小数
 */
public class Solution {

    public int maxDiff(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }

        int min = numbers[0];
        int maxDiff = numbers[1] - min;
        for (int i = 2; i < numbers.length; i++) {

            // 寻找最小值
            if (numbers[i-1] < min) {
                min = numbers[i -1];
            }

            // 计算最大利润
            int currentDiff = numbers[i] - min;
            maxDiff = Math.max(currentDiff,maxDiff);
        }

        return maxDiff;
    }

}
