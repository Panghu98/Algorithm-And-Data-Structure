package leetcode;

import java.util.Arrays;

/**
 * @author panghu
 * @title: Solution75B
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-16 下午10:41
 */
public class Solution75B {

    /**
     * 三路快速排序法
     * @param nums 传入的数组
     */
    static void sortColors(int[] nums){
        // nums[0...zero] == 0
        int zero = -1;
        // nums[two..n-1] == 2
        int two = nums.length;
        for (int i = 0;i < two;){
            if (nums[i] == 1){
                i++;
            }else if (nums[i] == 2){
                two--;
                swap(nums,i,two);
            }else {
                if (nums[i] != 0){
                    throw new IllegalArgumentException("数组中的值只能为1,2,3");
                }
                zero++;
                swap(nums,i,zero);
            }
        }
    }

    /**
     * 通过数组交换数值
     * @param arr  数组
     * @param x  数组索引1
     * @param y  数组索引2
     */
    static void swap(int[] arr,int x,int y){
        //temp用来临时存储值
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,0,0,0,0,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

}
