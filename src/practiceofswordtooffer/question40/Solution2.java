package practiceofswordtooffer.question40;

import array.Array;
import org.junit.Test;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:14 2020/3/11
 * @Modified By:
 */
public class Solution2 {

    /**
     * 获取最小的k个数
     * @param input 输入的数组
     * @param k 需要几个最小的数
     * @return
     */
    public ArrayList<Integer> getLeastNumbers(int[] input,int k) {

        if (input == null) {
            throw new NullPointerException();
        }

        if (input.length < k) {
            throw new IllegalArgumentException();
        }

        TreeSet<Integer> set = new TreeSet<>();
        int i = 0;
        while (set.size() < k) {
            set.add(input[i++]);
        }

        for (;i < input.length;i++) {
             Integer maxItemOfSet = set.last();
             if (input[i] < maxItemOfSet) {
                 set.remove(maxItemOfSet);
                 set.add(input[i]);
             }
        }

        return new ArrayList<>(set);
    }

    @Test
    public void test() {
        int[] arr = {6,4,3,5,1,2,7,8,9};
        ArrayList<Integer> list = getLeastNumbers(arr,5);
        System.err.println(list);
    }

}
