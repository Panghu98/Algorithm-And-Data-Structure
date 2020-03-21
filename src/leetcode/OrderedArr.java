package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:29 2020/3/18
 * @Modified By:
 */
public class OrderedArr {
    public List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>(10);

        String signal = "->";

        if (nums == null || nums.length == 0) {
            return list;
        }

        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }

        int start = nums[0];
        int end = start;

        for (int i = 1; i <= nums.length; i++) {
            String str = "";
            if (i == nums.length) {
                end = nums[i-1];
                if (start == end) {
                    list.add(str + start);
                }else {
                    list.add(start + signal + end);
                }
                return list;
            }
            if (nums[i] != nums[i - 1] + 1) {
                end = nums[i -1];
                if (end == start) {
                    list.add(str + start);
                }else {
                    list.add(start + signal + end);
                }
                start = nums[i];
            }
        }
        return list;
    }

    @Test
    public void test() {
       List<String> list = summaryRanges(new int[]{0,2,3,4,6,8,9});
        System.out.println(Arrays.toString(list.toArray()));
    }
}
