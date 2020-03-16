package practiceofswordtooffer.question56;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:21 2020/3/13
 * @Modified By:
 */
public class Solution_Copy {

    public int findNumsAppearOnce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,4,5,6,6,5,4,3,2,1,7,11,11
        };
        System.out.println(findNumsAppearOnce(arr));
    }

}
