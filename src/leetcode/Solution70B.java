package leetcode;

/**
 * @author panghu
 * @title: Solution70B
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
        System.out.println(climbStairs(40));
    }

}
