package leetcode;

/**
 * 题目要求：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */

import java.util.Arrays;

/**
 * @author panghu
 * @title: Solution75
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-16 下午10:06
 */



public class Solution75 {

    /**
     * 解决思路 计数排序  分别统计0,1,2的个数
     * 时间复杂度 O(n)
     * 空间复杂度 O(k)  k为元素取值范围
     */
    static void sortColors(int[] arr){
        //存放0,1,2三个元素的频率
        int[] count = new int[3];
        for (int value : arr) {
            if (value > 2 || value < 0) {
                throw new IllegalArgumentException("参数错误");
            }
            //记录各个数字的个数  arr[i]代表了0,1,或2  个数增加
            count[value]++;
        }

        //index用来记录数组的下标
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            arr[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            arr[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            arr[index++] = 2;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,0,0,0,0,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

}
