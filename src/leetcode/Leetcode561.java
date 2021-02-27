package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:47 2021/2/16
 * @Modified By:
 */
public class Leetcode561 {

    public int arrayPairSum(int[] nums) {

        int result = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(arrayPairSum(new int[]{1,4,3,2}));
        System.out.println(arrayPairSum(new int[]{}));
        System.out.println(arrayPairSum(new int[]{}));
        System.out.println(arrayPairSum(new int[]{}));

    }

}
