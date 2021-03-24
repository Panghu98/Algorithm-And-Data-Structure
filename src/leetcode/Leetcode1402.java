package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 18:09 2021/3/24
 * @Modified By:
 */
public class Leetcode1402 {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int preSum = 0;
        int ans = 0;
        for (int i = satisfaction.length -1; i >= 0; i--) {
            int value = satisfaction[i];
            if (value + preSum < 0) {
                break;
            }else {
                ans += value + preSum;
                preSum += value;
            }
        }

        return ans;
    }

    @Test
    public void test() {
        System.out.println(maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println(maxSatisfaction(new int[]{4,3,2}));
        System.out.println(maxSatisfaction(new int[]{-1,-4,-5}));
        System.out.println(maxSatisfaction(new int[]{-2,5,-1,0,3,-3}));

    }

}
