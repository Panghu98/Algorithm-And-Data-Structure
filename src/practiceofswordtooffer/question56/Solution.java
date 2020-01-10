package practiceofswordtooffer.question56;

/**
 * @author dengg
 */
public class Solution {

    public void findNumsAppearOnce(int[] arr,int num1,int num2) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //异或的结果
        int resultExclusiveOR = 0;

        for (int i = 0; i < arr.length; i++) {
            resultExclusiveOR ^= arr[i];
        }

        int indexOf1 =findFirstBitIs1(resultExclusiveOR);

        num1 = num2 = 0;
    }

    private int findFirstBitIs1(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit < 8 * Integer.SIZE)) {
            num = num >> 1;
            ++ indexBit;
        }
        return indexBit;
    }

    private boolean isBit1(int num,int indexBit) {
        num = num >> indexBit;
        return (num & 1) > 0;
    }

}
