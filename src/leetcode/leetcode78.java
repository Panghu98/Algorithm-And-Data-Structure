package leetcode;

import org.junit.Test;

import java.util.*;

public class leetcode78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        getSubSet(nums,0,list);

        return res;
    }

    private void getSubSet(int[] nums,int start,LinkedList<Integer> list) {

        res.add(new LinkedList<>(list));


        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            getSubSet(nums,i + 1, list);
            list.removeLast();
        }

    }

    @Test
    public void test() {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.err.println(subsets.size());
        subsets.forEach(System.out::println);
    }

}
