package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:43 2021/2/20
 * @Modified By:
 */
public class Leetcode697 {

    /**
     *中 找到最大维度
     * @param nums 核心思想在于最小的数组是从这个数出现的开头到末尾
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

}
