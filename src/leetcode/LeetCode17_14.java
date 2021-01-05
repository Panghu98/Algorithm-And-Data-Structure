package leetcode;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description: 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可
 * @Date: Created in 9:48 2021/1/5
 * @Modified By:
 */
public class LeetCode17_14 {

    public int[] smallestK(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }

}
