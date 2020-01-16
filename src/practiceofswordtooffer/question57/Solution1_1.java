package practiceofswordtooffer.question57;

import java.util.*;

/**
 * 这种接法针对于问题一没有很好地利用递增排序的特点
 */
public class Solution1_1 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>(16);

        //利用排序的特点
        for (int i = 0; i < array.length; i++) {
            if (set.contains(sum-array[i])) {
                list.clear();
                list.add(sum-array[i]);
                list.add(array[i]);
            }else {
                set.add(array[i]);
            }
        }
        return list;
    }

}
