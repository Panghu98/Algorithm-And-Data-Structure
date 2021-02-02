package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 17:44 2021/1/28
 * @Modified By:
 */
public class Leetcode724 {

    public int pivotIndex(int[] nums) {
        // key - 索引 value值 （如果是key和value倒置的话，value不一定能够作为唯一的key）
        Map<Integer, Integer> map = new HashMap<>(16);
        int reverseSum = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            map.put(i,reverseSum);
            // 中心索引的值不计算，所以先put
            reverseSum += nums[i];
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer right = map.get(i);
            if (right == left) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }

    @Test
    public void test() {
        System.out.println(pivotIndex(new int[]{0, 0, 0, 0, 1}));
    }

}
