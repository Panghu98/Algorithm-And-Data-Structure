package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 11:42 2021/2/7
 * @Modified By:
 */
public class Leetcode665 {

    /**
     * 从一个方向进行考虑
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        // 标志位
        boolean changed = false;

        for (int i = 0; i < nums.length -1; i++) {

            int next = nums[i + 1];
            int current = nums[i];
            if (current > next) {
                if (changed) {
                    return false;
                }

                changed = true;
                if (i + 2 < nums.length ) {
                    int nextNext = nums[i + 2];
                    if (nextNext < current ) {
                        if (i != 0) {
                            int pre = nums[i -1];
                            return pre < nextNext;
                        }
                    }
                }

            }

        }
        return true;

    }

    @Test
    public void test() {
        System.err.println(checkPossibility(new int[]{3,4,2,3}));
        System.err.println(checkPossibility(new int[]{5,7,1,8}));
        System.err.println(checkPossibility(new int[]{4,2,3}));
    }

}
