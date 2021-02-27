package leetcode;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: Created in 19:05 2020/3/3
 * @Modified By:
 */
public class LeetCode338 {

    //这里注意寻找动态规划的规律
    public int[] countBits(int num) {

        if (num == 0) {
            return new int[]{0};
        }

        //创建数组保存对象
        int[] arr = new int[num+1];
        for (int i = 1; i <= num; i++) {
            int maxPowerOf2 = getMaxPowerOf2(i);
            if (maxPowerOf2 == i) {
                arr[i] = 1;
            }else {
                arr[i] = 1 + arr[i-maxPowerOf2];
            }
        }

        return arr;
    }

    /**
     * 获取比num小的最大的2次幂
     * @param num 参数
     */
    private int getMaxPowerOf2(int num) {
        int result = 1;
        while (result <= num){
            result *= 2;
        }
        return result/2;
    }

    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while (i < b && i + b <= num) {
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }

        return ans;
    }

    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

    public static void main(String[] args) {
        LeetCode338 solution = new LeetCode338();
        System.err.println(Arrays.toString(solution.countBits(5)));

    }

}
