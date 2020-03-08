package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:20 2020/3/3
 * @Modified By:
 */
public class LeetCode650 {
    public int minSteps(int n) {
        if(n <= 1) {
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>(16);
        map.put(2,2);
        map.put(3,3);

        for (int i = 4; i <= n; i++) {
            //最大非己因素
            int number = getMaxPrimeNumber(i);
            if (number == 1) {
                //如果是质数
                map.put(i,i);
            }else {
                // 解释 i+number 首先i是number的（i/number）倍，但是只需要复制i/number-1次，但是要粘贴1次
                // 所以要加上i/number
                map.put(i,map.get(number)+i/number);
            }
        }
        return map.get(n);
    }

    /**
     * 获取最大非本身的因素
     * @param num
     * @return
     */
    private int getMaxPrimeNumber(int num) {
        for (int i = num /2;i >= 2;i--) {
            if (num % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LeetCode650 solution = new LeetCode650();
        System.err.println(solution.minSteps(8));
    }
}
