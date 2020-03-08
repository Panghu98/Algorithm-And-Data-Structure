package practiceofswordtooffer.question12;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 13:17 2020/3/3
 * @Modified By:
 */
public class HasPath2 {

    public static boolean hasPath(char[] arr,int columns,int rows,char[] ways) {
        //用于记录已经访问过的路径 true 被访问过 false未被访问过
        boolean[] visited = new boolean[arr.length];

        //寻找ways的第几个元素
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (subHashPath(arr,columns,rows,i,j,ways,index,visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean subHashPath(char[] arr,int columns,int rows,int column,
                               int row,char[] ways,int index,boolean[] visited) {


        if (row < 0 || column < 0 || row >= rows || column >= columns ||
                visited[row * columns + column] || arr[row * columns + column] != ways[index]) {
            return false;
        }

        int end = '\0';

        if (ways[index] == end) {
            return true;
        }

        visited[row * columns + column] = true;
        boolean hasPath = (subHashPath(arr, columns, rows, column-1, row, ways, index+1, visited) ||
                subHashPath(arr, columns, rows, column+1, row, ways, index+1, visited) ||
                subHashPath(arr, columns, rows, column, row-1, ways, index+1, visited) ||
                subHashPath(arr, columns, rows, column, row+1, ways, index+1, visited));
        if (!hasPath) {
            visited[row * columns + column] = false;
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
