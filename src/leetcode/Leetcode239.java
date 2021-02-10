package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:43 2021/2/9
 * @Modified By:
 */
public class Leetcode239 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先把窗口的前 k - 1 填满
                window.push(nums[i]);
            } else {
                // 窗口开始向前滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口中的最大元素记入结果
                res.add(window.max());
                // 移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将 List 类型转化成 int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }



    class MonotonicQueue {

        private LinkedList<Integer> deque = new LinkedList<>();

        // 在队尾添加元素 n
        void push(int n) {
            while (deque.size() > 0 && deque.peekLast() < n) {
                deque.pollLast();
            }

            deque.addLast(n);
        };
        // 返回当前队列中的最大值
        int max() {
            return deque.getFirst();
        };
        // 移除
        void pop(int n) {
            if (n == deque.getFirst()) {
                deque.pollFirst();
            }
        };
    }

}
