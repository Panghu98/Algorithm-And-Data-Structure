package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:09 2021/2/28
 * @Modified By:
 */
public class Leetcode896_2 {
    public boolean isMonotonic(int[] A) {
        return isSorted(A, true) || isSorted(A, false);
    }

    public boolean isSorted(int[] A, boolean increasing) {
        int n = A.length;
        if (increasing) {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
