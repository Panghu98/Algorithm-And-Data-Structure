package leetcode;

/**
 * @author panghu
 * @title: Solution70
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-13 下午6:50
 */
public class Solution70 {

    private static int[] arr = new int[100 + 1];

    public static int climbStairs(int n) {
        if (n==0 || n==1){
            return 1;
        }
        if (arr[n] == 0){
            arr[n] = climbStairs(n-1) + climbStairs(n-2);
        }
        return arr[n];
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(40));
    }

}
