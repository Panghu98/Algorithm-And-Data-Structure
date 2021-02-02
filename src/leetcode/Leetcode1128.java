package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:29 2021/1/26
 * @Modified By:
 */
public class Leetcode1128 {

    Map<String,Integer> collection  = new HashMap<>();

    int totalCount = 0;

    private final static String separate = "-";

    public int numEquivDominoPairs(int[][] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            int[] dominoe = dominoes[i];
            int head = Math.max(dominoe[0],dominoe[1]);
            int tail = Math.min(dominoe[0],dominoe[1]);

            insertKey(head,tail);
        }

        return totalCount;

    }

    /**
     * 插入key,正序倒序都进行插入
     */
    private void insertKey(int head,int tail) {
        String key = head + separate + tail;
        // 重复数量
        Integer count = collection.get(key);
        if ( count == null) {
            collection.put(key,1);
        }else {
            int sum = getCount(count);
            totalCount += sum;
            if (sum != 1) {
                totalCount -= getCount(count - 1);
            }
            collection.put(key, count + 1);
        }
    }

    private int getCount(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i;
        }

        return sum;
    }

    @Test
    public void test() {
        System.err.println(getCount(0));
        System.err.println(getCount(1));
        System.err.println(getCount(2));
        System.out.println(numEquivDominoPairs(new int[][]{
                {1,2},
                {1,2},
                {1,1},
                {1,2},
                {2,2}
        }));
    }

}
