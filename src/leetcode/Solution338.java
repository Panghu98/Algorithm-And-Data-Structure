package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
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
 */
 
public class Solution338 {
    public static int[] countBits(int num) {
        if (num == 0){
            return new int[]{0};
        }
        int ret = getNum(num);
        int[] arr = new int[ret];
        for (int i = ret-1; i >= 0 ; i--) {
            int temp = 1 << i;
            if (num >= temp){
                arr[i] = 1;
                num = num - (temp);
            }else {
                arr[i] = 0;
            }
        }
        return arr;

    }

    /**
     * 获得二进制最高数位
     * num = 1,ret = 1;
     * num = 2,ret = 2;
     * num = 3,ret = 2;
     */
    private static int getNum(int num){
        int i = 1;
        int flag = 0;
        while (i <= num){
            i *= 2;
            flag++;
        }
        return flag;
    }

    @Test
    public void test(){
        System.out.println(getNum(0));
    }
}
