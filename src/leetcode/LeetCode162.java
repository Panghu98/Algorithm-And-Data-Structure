package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:25 2020/3/30
 * @Modified By:
 */
public class LeetCode162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isPeak(nums,i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isPeak(int[] nums,int index) {
        boolean left = false;
        boolean right = false;

        if (index == 0) {
            left = true;
        }else if (nums[index-1] < nums[index]) {
            left = true;
        }

        if (index == nums.length - 1) {
            right = true;
        }else if (nums[index+1] < nums[index]) {
            right = true;
        }


        return left && right;
    }

    @Test
    public void test() {
        System.out.println(findPeakElement(new int[]{0,1}));
    }

}
