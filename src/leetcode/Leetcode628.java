package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 11:15 2021/1/20
 * @Modified By:
 */
public class Leetcode628 {

    public int maximumProduct(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        List<Integer> sortList = list.
                stream().
                sorted(Comparator.comparingInt(item -> -item)).
                collect(Collectors.toList());
        return calculateSum(sortList);
    }

    private int calculateSum(List<Integer> numbers) {
        int size = numbers.size();
        // 排序后的数组数量一定大于三
        Integer last = numbers.get(size - 1);
        Integer secondLast = numbers.get(size - 2);

        Integer second = numbers.get(1);
        Integer third = numbers.get(2);


        Integer first = numbers.get(0);
        if (first < 0) {
            return first * second * third;
        }else {
            // last和secondLast不一定都为正数
            // last和secondLast都为负数的积不一定比二三位积大
            return first * Math.max(last * secondLast,second * third);
        }

    }

}
