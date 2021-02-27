package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:19 2021/2/13
 * @Modified By:
 */
public class Leetcode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length <= 1) {
            return list;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            list.add(0);
        }

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            list.set(index - 1,1);
        }


        int length = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer value = list.get(i);
            if (value == 0) {
                int trueIndex = i + 1;
                list.set(length++,trueIndex);
            }
        }

        return list.subList(0,length);

    }

    //4, 3, 2, 7, 8, 2, 3, 2
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            // 在该index上出现了，进行增加（没出现的则还是在【1-n】之间，在的话因为加了n，所以该位置的值一定超过了n）
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 2}));
    }

}
