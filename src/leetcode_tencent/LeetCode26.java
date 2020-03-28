package leetcode_tencent;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * @Date: Created in 9:12 2020/3/28
 * @Modified By:
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }

        int length = nums.length;
        int oldNum = nums[0];
        int newLength = 1;

        //用于标记交换数组的下标
        int swapIndex = 1;
        // 记录上个不同数字
        for (int i = 1; i < length; i++) {
            if (nums[i] != oldNum) {
                // 更改上一个不同的数字,注意和下面一条命令不能交换顺序
                oldNum = nums[i];
                // 交换位置
                swap(nums,i,swapIndex++);
                // 增加长度
                newLength++;
            }
        }

        return newLength;
    }

    private void swap(int[] arr,int left,int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(nums);
    }

}
