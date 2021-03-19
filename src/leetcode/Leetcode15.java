package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:24 2021/3/18
 * @Modified By:
 */
public class Leetcode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if(nums == null || nums.length < 3) return lists;

        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length -1;


            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i -1] == nums[i]) {
                continue;
            }

            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    lists.add(list);

                    while (left < right && nums[left] == nums[left +1] ) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right -1]) {
                        right--;
                    }

                    left++;
                    right--;
                }


                if (sum > 0 ) {
                    right--;
                }

                if (sum < 0) {
                    left++;
                }

            }

        }

        return lists;

    }

    @Test
    public void test() {
        int[] ints = {-2,0,1,1,2};
        List<List<Integer>> lists = threeSum(ints);
        lists.forEach(item -> item.forEach(System.out::println));
    }

}
