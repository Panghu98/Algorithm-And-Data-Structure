package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:48 2021/2/28
 * @Modified By:
 */
public class Leetcode674 {

    public int findLengthOfLCIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(nums,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1 );
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i],res );
        }

        return res;
    }

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (list.isEmpty()) {
                list.addFirst(value);
            }else if (value > list.getLast()) {
                list.addLast(value);
            // 清空单调队列
            }else {
                while (!list.isEmpty()) {
                    list.removeLast();
                }
                list.addFirst(value);
            }

            maxLength = Math.max(list.size(),maxLength);
        }

        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findLengthOfLCIS(new int[]{2,1,3}));
    }

}
