package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:11 2021/2/15
 * @Modified By:
 */
public class Leetcode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && nums[j] == 1) j++;
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,0,1,1,1}));
    }

}
