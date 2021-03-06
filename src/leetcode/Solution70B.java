package leetcode;

/**
 * @author panghu
 * @title: 动态规划  从下向上
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-14 下午6:42
 */
public class Solution70B {

    private static int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i]  = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        for (int i = 5; i < 41; i+= 5) {
            long start = System.nanoTime();

            climbStairs(i);
            long end = System.nanoTime();

            System.out.println("当n="+i+"算法总耗时"+(end-start)+"  ns");
        }
    }

}
