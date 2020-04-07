package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 *
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 *
 * @Date: Created in 20:48 2020/4/7
 * @Modified By:
 */
public class LeetCode_16_11 {

    public int[] divingBoard(int shorter, int longer, int k) {
        Set<Integer> set = new HashSet<>();
        // 其实数值
        addItem(0,k,set,shorter,longer);
        int length = set.size();
        int[] arr = new int[length];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            arr[index++] = iterator.next();
        }

        Arrays.sort(arr);
        return arr;
    }

    private void addItem(int index,int k,Set<Integer> set,int shorter,int longer) {
        if (index <= k) {
            set.add(index*longer + (k - index)*shorter);
            addItem(++index, k, set, shorter, longer);
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(divingBoard(1, 2, 3)));
    }

    /**
     * 更好的解法
     * 利用两者之间的差值进行，从最小值开始相加
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard2(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] result = new int[k + 1];
        if (shorter == longer) {
            return new int[]{shorter * k};
        } else {
            result[0] = shorter * k;
            for (int i = 1; i < result.length; i++) {
                result[i] = result[i - 1] + longer - shorter;
            }
        }
        return result;
    }

}
