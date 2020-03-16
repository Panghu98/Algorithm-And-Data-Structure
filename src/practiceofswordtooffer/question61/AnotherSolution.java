package practiceofswordtooffer.question61;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:30 2020/3/16
 * @Modified By:
 */
public class AnotherSolution {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        int firstNum = numbers[0];
        int indexOfStart = Math.max(firstNum - 4, 1);
        int indexOfEnd = Math.min(firstNum+4,13);

        // 数组的长度
        int length = indexOfEnd - indexOfStart + 1;

        // 辅助数组
        boolean[] arr =new boolean[length];

        // 标识被占有
        arr[firstNum - indexOfStart] = true;

        int numberOfZero = 0;
        for (int i = 1; i < numbers.length; i++) {
            int data = numbers[i];

            if (data == 0) {
                numberOfZero++;
                // 进入下一个循环
                continue;
            }

            if (data < indexOfStart || data > indexOfEnd) {
                return false;
            }
            // 如果没有没占有
            if (!arr[data - indexOfStart]) {
                arr[data - indexOfStart] = true;
            }else {
                return false;
            }
        }

        // 用于标记存储最远两个元素的距离
        int start = 0,end = arr.length -1;
        while (!arr[start]){
            start++;
        }

        while (!arr[end]){
            end--;
        }

        if (numberOfZero == 0 && end -start == 4) {
            return true;
        }

        return end - start <= numberOfZero;
    }

    @Test
    public void test() {
        int[] arr = {4,3,5,2,6};
        boolean result = isContinuous(arr);
        System.err.println(result);
    }
}
