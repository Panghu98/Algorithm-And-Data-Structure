package leetcode;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:45 2020/3/3
 * @Modified By:
 */
public class LeetCode10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] newArr = new int[n+m];
        int indexOfNewArr = 0;
        int indexOfA =0;
        int indexOfB =0;
        while(indexOfA < m && indexOfB < n) {
            newArr[indexOfNewArr++] = (A[indexOfA] < B[indexOfB])?A[indexOfA++]:B[indexOfB++];
        }

        if (indexOfA != m) {
            while (indexOfNewArr != newArr.length) {
                newArr[indexOfNewArr++] = A[indexOfA++];
            }
        }else {
            while (indexOfNewArr != newArr.length) {
                newArr[indexOfNewArr++] = B[indexOfB++];
            }
        }

        System.arraycopy(newArr, 0, A, 0, newArr.length);
    }

    public static void main(String[] args) {
        LeetCode10_01 solution = new LeetCode10_01();
        int[] c = new int[]{1,2,3,4,6,6,7,8};
        int[] a = new int[20];
        System.arraycopy(c,0,a,0,c.length);
        System.err.println(Arrays.toString(a));
        int[] b = new int[]{1,2,4,4,5,5,6};
        solution.merge(a,8,b,7);
        System.err.println(Arrays.toString(a));
    }
}
