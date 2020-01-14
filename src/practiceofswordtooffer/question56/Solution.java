package practiceofswordtooffer.question56;

/**
 * @author dengg
 */
public class Solution {

    /**
     * 寻找只出现过一次的数字
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;

        //求出整个数组的异或结果
        //因为除了两个只出现一次的数字其他的数字都出现了两次，所以最终的异或结果为哪两个只出现了一次的数字的异或
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }


        //获取最激活结果最高位的1的位置
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 获取所以对高位的一
     * @param bitResult  数字
     * @return
     */
    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            //右移一位
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    /**
     * 判断对应的索引位是否为1
     * @param target
     * @param index
     * @return
     */
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
