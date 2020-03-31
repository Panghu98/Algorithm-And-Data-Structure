package leetcode;

import array.Array;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12
 * @Date: Created in 20:32 2020/3/30
 * @Modified By:
 */
public class LeetCode198 {

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }



        int num1 = nums[0];
        int num2 = Math.max(num1,nums[1]);

        int maxValue = 0;
        for (int i = 2; i < nums.length; i++) {
            maxValue = Math.max(num1+nums[i],num2);
            num1 = num2;
            num2 = maxValue;
        }

        return Math.max(num1,num2);
    }

    public int rob(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int[] noHeadArr = Arrays.copyOfRange(arr,1,arr.length);
        int[] noTailArr = Arrays.copyOfRange(arr,0,arr.length-1);
        return Math.max(rob2(noHeadArr),rob2(noTailArr));
    }

    @Test
    public void test() {
        int[] arr = new int[]{4,2,3,1,4};
        System.out.println(rob2(arr));
    }

}
