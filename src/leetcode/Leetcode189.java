package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description: https://leetcode-cn.com/problems/rotate-array/
 * @Date: Created in 11:17 2021/1/8
 * @Modified By:
 */
public class Leetcode189 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int offset = k % length;
        // 直接移动了一圈，不变化
        if (offset == 0) {
            return;
        }

        // 临时数组，用于存储变化后的值
        int[] numsTemp = new int[length];
        for (int i = 0; i < nums.length; i++) {
            // 偏移后的实际坐标
            int index = (i + offset)%length;
            numsTemp[index] = nums[i];
        }

        System.arraycopy(numsTemp,0,nums,0,nums.length);
    }

    @Test
    public void test() {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

}
