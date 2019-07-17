package leetcode;

import array.Array;

import java.util.Arrays;

/**
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 *
 * @author panghu
 * @title: Solution88
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-17 下午7:15
 */
public class Solution88 {

    //有点类似于合并排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] mergeArr = new int[m+n];

        int p1 = 0;
        int p2 = 0;
        int index = 0;


        while (p1< m &&  p2 < n){
            if (nums1[p1] < nums2[p2]){
                mergeArr[index++] = nums1[p1++];
            }else{
                mergeArr[index++] = nums2[p2++];
            }
        }

        while (p1 < m){
            mergeArr[index++] = nums1[p1++];
        }

        while (p2 < n){
            mergeArr[index++] = nums2[p2++];
        }
        System.arraycopy(mergeArr, 0, nums1, 0, nums1.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arr2 = {1,2,3};

        merge(arr,3,arr2,3);
        System.out.println(Arrays.toString(arr));
    }

}
