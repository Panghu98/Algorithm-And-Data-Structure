package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:18 2021/2/28
 * @Modified By:
 */
public class Leetcode896 {

    public boolean isMonotonic(int[] A) {

        if (A == null || A.length <= 1) {
            return true;
        }

        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < A.length; i++) {
            map.put(i,A[i]);
        }

        int start = A[0];

        Arrays.sort(A);

        boolean reverse = false;

        if (start != A[0]) {
            reverse = true;
        }

        // 判断是升序还是降序
        for (int i = 0; i < A.length; i++) {
            Integer value = map.get(i);
            // 升序，未反转
            if (value != A[i] && !reverse) {
                return false;
            }else if (value != A[A.length -1 -i] && reverse) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(isMonotonic(new int[]{3,2,1,1}));
        System.out.println(isMonotonic(new int[]{1,2,3,3}));
        System.out.println(isMonotonic(new int[]{1,3,2,4}));
    }

}
