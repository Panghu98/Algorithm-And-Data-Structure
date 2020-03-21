package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * 思路
 * 标签：动态规划
 * 遍历数组时计算当前最大值，不断更新
 * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
 * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
 * 当负数出现时则imax与imin进行交换再进行下一步计算
 * 时间复杂度：O(n)O(n)
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Date: Created in 21:02 2020/3/21
 * @Modified By:
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        int imax = nums[0];
        int imin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int data = nums[i];
            // 如果下一个数小于零，最大数和最小数进行交换
            if (data < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * data,data);
            imin = Math.min(imin * data,data);

            max = Math.max(max,imax);

        }

        return max;
    }

    /**
     * 其实这一道题是典型的动态规划问题
     */
    public int maxProduct(int[] nums,int length) {
        int[] dp_max = new int[nums.length+1];
        int[] dp_min = new int[nums.length+1];
        if(nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        // 由于存在负数，所以需要维护两个数组
        // dp_max[i] 指的是以第 i 个数结尾的 乘积最大 的连续子序列
        // dp_min[i] 指的是以第 i 个数结尾的 乘积最小 的连续子序列
        dp_max[0] = 1;
        dp_min[0] = 1;
        for (int i = 1;i <= nums.length;i++){
            // 如果数组的数是负数，那么会导致 max 变成 min，min 变成 max
            // 故需要交换dp
            if(nums[i-1] < 0){
                int temp = dp_min[i-1];
                dp_min[i-1] = dp_max[i-1];
                dp_max[i-1] = temp;
            }
            dp_min[i] = Math.min(nums[i-1],dp_min[i-1]*nums[i-1]);
            dp_max[i] = Math.max(nums[i-1],dp_max[i-1]*nums[i-1]);
            max = Math.max(max,dp_max[i]);
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = new int[]{-1,0,-2};
        System.out.println(maxProduct(arr));
    }

}
