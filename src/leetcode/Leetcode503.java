package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 17:14 2021/3/6
 * @Modified By:
 */
public class Leetcode503 {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0; i < nums.length; i++) {
            int index = (i + 1) % length;
            int minIndexValue = -1;
            while (index != i) {
                if (nums[index] > nums[i]) {
                    minIndexValue = nums[index];
                    break;
                }

                index = (++index) % length;
            }

            result[i] = minIndexValue;
        }

        return result;

    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret,-1);
        Deque<Integer> stack = new LinkedList<>();
        // 这里是n *2 加一遍，目的是为了数组的最后一个数也能够完整的遍历整个数组
        for (int i = 0; i < n * 2 -1 ; i++) {
            while ( !stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }

            stack.push(i % n);

        }

        return ret;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElements2(new int[]{1, 2, 3, 4, 3})));
    }

}
