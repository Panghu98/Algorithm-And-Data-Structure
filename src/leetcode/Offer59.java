package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:38 2021/2/22
 * @Modified By:
 */
public class Offer59 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0},4)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        MonotonicQueue queue = new MonotonicQueue();

        int[] result = new int[nums.length - k + 1];

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < k -1) {
                queue.push(nums[i]);
            }else {
                queue.push(nums[i]);
                result[index++] = queue.max();
                queue.pop(nums[i - k + 1]);
            }

        }

        return result;

    }


    class MonotonicQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        private void push(int num) {
            // 注意这里使用 < ,否则出现重复的误删
            while (!queue.isEmpty() && queue.getLast() < num) {
                queue.removeLast();
            }

            queue.addLast(num);
        }

        private int max() {
            return queue.getFirst();
        }

        private void pop(int n) {
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }



    }


}
