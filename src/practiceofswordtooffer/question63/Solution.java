package practiceofswordtooffer.question63;

public class Solution {

    public int maxDiff(int[] numbers) {
        //特殊参数处理
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int maxNum = numbers[0];
        int minNum = numbers[0];

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > maxNum) {
                maxNum = numbers[i];
            } else if (numbers[i] < minNum) {
                minNum = numbers[i];
            }
        }

        return maxNum-minNum;
    }

}
