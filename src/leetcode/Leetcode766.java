package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:47 2021/2/22
 * @Modified By:
 */
public class Leetcode766 {
    public boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix == null || matrix.length <= 1) {
            return true;
        }

        int[] tmp = new int[matrix[0].length + matrix.length - 1];
        int index = matrix.length-1;
        for (int i = 0; i < matrix[0].length; i++) {
            tmp[index++] = matrix[0][i];
        }

        index = matrix.length - 2;

        for (int i = 1; i < matrix.length; i++) {
            tmp[index--] = matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0,innerIndex = matrix.length - 1 - i; j < matrix[i].length; j++,innerIndex++) {
                if (tmp[innerIndex] != matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;

    }


    @Test
    public void test() {
        int[][] matrix = {
                {1,2},
                {2,2}
//                {1, 2, 3, 4},
//                {5, 1, 2, 3},
//                {9, 5, 1, 2}
        };

        boolean toeplitzMatrix = isToeplitzMatrix(matrix);
        System.out.println(toeplitzMatrix);
    }
}
