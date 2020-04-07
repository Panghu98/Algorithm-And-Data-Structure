package practiceofswordtooffer.question49;

import org.junit.Test;

/**
 * @author dengg
 */
public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        //所谓的潜在位置指的就是该位置（对应的丑数分别乘以2、3、5后）大于已知最大丑数最小值的位置
        //初始化三个指向三个潜在成为最小丑数的位置
        // 会将前面的每一个数字都乘一遍
        // 每一个因子相乘都保留在原位置  result[p]存储了最小的因子
        int p2 = 0,p3 = 0,p5 = 0;
        int[] result = new int[index];
        //第一个丑数是1
        result[0] = 1;
        for (int i = 1; i < index; i++) {
            //丑数一定是三个潜在最小丑数中的最小值，

            // 我觉得这里是非常巧妙的
            // p2,p3,p5分别指向数组中了之前相乘的最小数
            result[i] = Math.min(result[p2]*2, Math.min(result[p3]*3, result[p5]*5));

            //为了防止重复需要三个if都能够走到
            if(result[i] == result[p2]*2) {
                p2++;
            }
            if(result[i] == result[p3]*3) {
                p3++;
            }
            if(result[i] == result[p5]*5) {
                p5++;
            }

        }

        return result[index-1];
    }
    @Test
    public void test() {
       int result = GetUglyNumber_Solution(17);
        System.out.println(result);
    }

}
