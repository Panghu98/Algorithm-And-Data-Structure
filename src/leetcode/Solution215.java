package leetcode;

import java.util.PriorityQueue;

/**
 * @author panghu
 * @title: Solution215
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-18 上午10:46
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // output
        return heap.poll();
    }


}
