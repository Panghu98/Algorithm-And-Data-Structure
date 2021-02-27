package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:51 2021/2/25
 * @Modified By:
 */
public class Leetcode867 {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] transposed = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;

    }

}
