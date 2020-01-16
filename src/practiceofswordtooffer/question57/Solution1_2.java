package practiceofswordtooffer.question57;

import java.util.ArrayList;

public class Solution1_2 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        //输入参数验证
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException();
        }

        //用于存储返回结果
        ArrayList<Integer> list = new ArrayList<>();


        int endPointer = array.length-1;
        int startPointer = 0;

        while (startPointer < endPointer) {
            int result = array[startPointer] + array[endPointer];
            if (result > sum) {
                endPointer --;
            }else if (result < sum){
                startPointer ++;
            }else {
                list.add(array[startPointer]);
                list.add(array[endPointer]);
                return list;
            }
        }
        return list;
    }
}
