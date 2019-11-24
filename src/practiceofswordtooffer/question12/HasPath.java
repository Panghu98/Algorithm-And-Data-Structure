package practiceofswordtooffer.question12;

import org.junit.Test;

/**
 * 数据量相同的情况下，二维数组比一维数组需要开辟更大的内存空间。
 * 所以，最好是使用维数组代替二维数组
 */
public class HasPath {

    boolean hasPath(char[] matrix, int columns, int rows, char[] ways) {

        if (matrix == null || rows < 1 || columns < 1 || ways == null) {
            return false;
        }

        boolean[] visited = new boolean[columns * rows];

        int index = 0;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (subHasPath(matrix, columns, rows, ways, index, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean subHasPath(char[] matrix, int columns, int rows, char[] ways, int index, int column, int row, boolean[] visited) {

        //结束条件判断
        if (row < 0 || column < 0 || row >= rows || column >= columns || visited[column * row + column] || ways[index] !=
                matrix[column * row + column]) {
            return false;
        }

        //如果有一个是false的话就直接返回，true是当遍历完了路劲之后再进行返回

        //如果已经遍历到寻找路线的结尾
        if (ways[index] == '\0') {
            return true;
        }

        boolean hasPath;
        //标记该位置已经被访问
        visited[row * column + column] = true;
        hasPath = subHasPath(matrix, columns, rows, ways, ++index, ++row, column, visited)
                || subHasPath(matrix, columns, rows, ways, ++index, --row, column, visited)
                || subHasPath(matrix, columns, rows, ways, ++index, row, ++column, visited)
                || subHasPath(matrix, columns, rows, ways, ++index, row, --column, visited);

        if (!hasPath) {
            visited[column * row + row] = false;
        }

        return hasPath;
    }

    // =======测试代码========

    // A B T G
    // C F C S
    // J D E H

    // BFCTB
    @Test
    public void test1() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCTB".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test1 passed.");
        else
            System.out.println("Test1 failed.");
    }

}
