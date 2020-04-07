package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 九十度旋转二维数组
 * @Date: Created in 20:13 2020/4/7
 * @Modified By:
 */
public class LeetCode_01_07 {

    public void rotate(int[][] matrix) {
        int N = matrix.length;
        // 换角
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i]; // 左下角对应的位置
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j]; // 右下角对应的位置
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i]; // 右上角对应的位置
                matrix[j][N - 1 - i] = temp;
            }
        }
        // 如果N是奇数，还要换中心边，中心点不用换
        if (N % 2 == 1) {
            int m = N / 2;
            for (int i = 1; i <= m; i++) {
                int temp = matrix[m - i][m];
                matrix[m - i][m] = matrix[m][m - i];
                matrix[m][m - i] = matrix[m + i][m];
                matrix[m + i][m] = matrix[m][m + i];
                matrix[m][m + i] = temp;
            }
        }
    }

    @Test
    public void test() {
        rotate(new int[][]{
                {1, 2, 3, 4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        });
    }

}
