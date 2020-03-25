package leetcode_tencent;

import array.Array;
import org.junit.Test;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 *public List<List<Integer>> threeSum(int[] nums) {
 *
 *     }
 * @Date: Created in 21:11 2020/3/25
 * @Modified By:
 */
public class Solution15 {
    /**
     * 去重有问题 我的想法是利用set进行去重，但是又会存在空间浪费(还是存在问题Set<SortList就OK>)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 辅助hash表
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            Integer result = map.get(key);
            if (result != null) {
                map.put(key,result+1);
            }
            else {
                map.put(key,1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            Integer key  = nums[i];
            // 复制对象
            HashMap<Integer,Integer> mapCopy = new HashMap<>(map);

            minusTimes(key,mapCopy);

            for (int j = i+1; j < nums.length; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                minusTimes(nums[j],mapCopy);
                // 最后一个key值
                Integer lastKey = -nums[i] - nums[j];
                if (map.containsKey(lastKey)) {
                    list.add(lastKey);
                    lists.add(list);
                }
            }
        }
        // help GC
        map.clear();
        return lists;
    }

    private void minusTimes(Integer key,HashMap<Integer,Integer> map) {
        Integer times = map.get(key);
        if (times == null) {
            throw new IllegalArgumentException("map中不包括该参数");
        }
        // 对map进行删除处理
        if (times == 1) {
            map.remove(key);
        }else {
            map.put(key,times-1);
        }
    }

    /**
     * 大佬的解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length -3; i++) {
            int left = i + 1;
            int right = nums.length -1 ;

            if (nums[i] >0) {
                return lists;
            }

            //去重，前一个已经执行了
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int value = nums[i];
            while (left < right) {
                int sum = value + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }else if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[right]);
                    list.add(nums[i]);
                    list.add(nums[left]);
                    lists.add(list);
                    while(left < right && nums[left+1] == nums[left]) {
                        ++left;
                    }
                    while (left < right && nums[right-1] == nums[right]) {
                        --right;
                    }
                    ++left;
                    --right;
                }else {
                    right--;
                }
            }
        }
        return lists;
    }

    @Test
    public void test() {
        List<List<Integer>> lists = threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println();
    }
}
