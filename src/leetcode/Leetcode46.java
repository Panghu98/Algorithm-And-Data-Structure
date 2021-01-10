package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:07 2021/1/10
 * @Modified By:
 */
public class Leetcode46 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        permute(nums,list);

        return res;
    }

    private void permute(int[] nums, LinkedList<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permute(nums, list);
            list.removeLast();
        }

    }

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.err.println(permute.size());
        permute.forEach(System.out::println);
    }

}
