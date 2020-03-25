package leetcode_tencent;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 18:47 2020/3/25
 * @Modified By:
 */
public class Solution33 {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1 && target != nums[0]) {
            return -1;
        }

        int start = nums[0];

        int rotateIndex = getIndexOfSmallArr(0,nums.length-1,nums);

        // 如果是顺序数组
        if (rotateIndex == -1) {
                return binarySearch(0,nums.length-1,nums,target);
        }

        if (target == start) {
            return 0;
        }else if (target < start) {
            return binarySearch(rotateIndex,nums.length-1,nums,target);
        }else {
            return binarySearch(1,rotateIndex-1,nums,target);
        }
    }

    private int binarySearch(int left, int right, int[] arr,int target) {

        int middle = (left + right)/2;
        if (arr[middle] == target) {
            return middle;
        }
        if (left > right) {
            return -1;
        }
        if (arr[middle] < target) {
            return binarySearch(middle+1, right, arr, target);
        }else {
            return binarySearch(left,middle-1,arr,target);
        }
    }

    private int getIndexOfSmallArr(int left, int right, int[] arr) {

        //用于判断当前的位置是大数组还是小数组
        int start = arr[0];

        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;
        // 左边不越界
        if (middle > 1) {
            if (arr[middle] < arr[middle - 1]) {
                return middle;
            }
        }

        // 右边不越界
        if (middle < arr.length - 1) {
            if (arr[middle + 1] < arr[middle]) {
                return middle + 1;
            }
        }

        if (arr[middle] < start) {
            return getIndexOfSmallArr(left, middle - 1, arr);
        } else {
            return getIndexOfSmallArr(middle + 1, right, arr);
        }
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{3,4,5,6,1,2},2));
    }
}
