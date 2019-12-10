package practiceofswordtooffer.question21;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {

    private static void swap(int[] arr,int indexX,int indexY) {
        int temp = arr[indexX];
        arr[indexX] = arr[indexY];
        arr[indexY ] = temp;
    }

    public static void reOrderOddEven(int[] arr) {
        //寻找奇数索引
        int oddIndex;
        //寻找偶数索引
        int evenIndex;

        int i = 0,j = arr.length-1;
        while (j >= i) {
            //从左边开始遍历寻找第一个偶数
            // && i < j --注意加这个是为了同步
            //假设是 1 2 3 4 5 6
            //进行到某一步的时候为 1 5 3 4 2 6
            //此时 i为2,j为3还将继续,导致最后结果为 1 5 4 3 2 6
            while (!condition1(arr[i]) && i < j) {
                i++;
            }
            evenIndex = i++;

            //从右边开始遍历寻找第一个奇数
            while (!condition2(arr[j]) && i < j) {
                j--;
            }
            oddIndex = j--;

            swap(arr,evenIndex,oddIndex);
        }
    }

    /**
     * 偶数
     * @param number 输入参数
     * @return 是否为偶数
     */
    public static boolean condition1(int number) {
        return number%2==0;
    }


    /**
     * 奇数
     * @param number 输入参数
     * @return 是否为奇数
     */
    public static boolean condition2(int number) {
        return number%2!=0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reOrderOddEven(arr);
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i]+" ");
        }
    }

}
