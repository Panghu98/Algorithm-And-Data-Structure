package leetcode;

public class Solution64 {
    public static int minPathSum(int[][] grid) {
        int columns = grid[0].length;
        int rows = grid.length;

        //使用以为数组存储更加节省空间
        int[] value = new int[rows*columns];

        value[0] = grid[0][0];
        //存储列边界值
        for (int i = 1; i < columns; i++) {
            value[i] =  value[i-1] + grid[0][i];
        }

        //存储行边界值
        for (int i = 1; i < rows; i++) {
            value[i*columns] =  value[i*columns-columns] + grid[i][0];
        }

        //动态规划
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                value[i*columns+j] =grid[i][j] + Math.min(value[i*columns+j-1],value[(i-1)*columns+j]);
            }
        }

        return value[rows*columns-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,7,1,2},{3,2,6,3},{5,1,4,1},{1,4,5,5}};
        int result = minPathSum(arr);
        System.err.println(result);
    }


}
