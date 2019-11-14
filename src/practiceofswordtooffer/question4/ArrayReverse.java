package practiceofswordtooffer.question4;

/**
 * @author dengg
 */
public class ArrayReverse {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6};
        //+1是为了防止数组越界
        int middle = (arr.length-1) >> 1;
        for (int i = middle; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-1-i] = temp;
        }

    }

    /**
     * length 为奇数时，最大的下标为length -1 为偶数 中间的和自己交换一次然后交叉交换
     * length 为偶数时，最大的下标为length -1 为奇数 交叉交换
     */

}
