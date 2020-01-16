package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panghu
 * @title: Solution1_1
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-8 下午7:57
 *
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 *
 *
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(10);
        for(int i = 0; i< nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)) {
                return new int[] {map.get(key),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
        循环遍历数组，创建一个关联数组，在关联数组（这个关联数组很关键，这个关联数组
        是将自身的数值作为了key，将索引作为了value）当中寻找对应的值  找得到就返回
        关联数组的键值和数组的当前索引
     */

}
