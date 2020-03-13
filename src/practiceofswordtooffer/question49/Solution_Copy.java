package practiceofswordtooffer.question49;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 17:29 2020/3/13
 * @Modified By:
 */
public class Solution_Copy {

    public int getUglyNumberSolution(int index) {
        //参数验证
        if (index < 0) {
            return -1;
        }

        //初始化三个指向三个潜在成为最小丑数的位置 -- 重点理解
        //
        int p2 = 0,p3 = 0,p5 = 0;
        int[] result = new int[index];
        //第一个丑数是1
        result[0] = 1;
        for (int i = 0; i < index; i++) {
            //最新的丑数一定是三个潜在最小丑数中的最小值 *2、3、5的结果
            result[i] = Math.min(result[p2]*2, Math.min(result[p3]*3, result[p5]*5));

            //判断是那个最小因子
            if (result[i] == result[p2]) {
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

}
