package practiceofswordtooffer.question13;

public class MovingCount {

    public static int movingCount(int threshold, int columns, int rows) {
        boolean[] visited = new boolean[columns * rows];
        int column = 0, row = 0;
        int count = movingCount(threshold, columns, rows, visited, column, row);
        visited = null;
        return count;
    }

    /**
     * 计算机器人能够行走的范围
     *
     * @param threshold 阀值
     * @param columns   列长
     * @param rows      行宽
     * @param visited   用于记录微爱之是否被访问过
     * @param row       当前行
     * @param column    当前列
     * @return 数量
     */
    private static int movingCount(int threshold, int columns, int rows, boolean[] visited, int column, int row) {



        int count = 0;
        if (check(threshold, columns, rows, visited, column, row)) {
            visited[row * columns + column] = true;

            count = 1 + movingCount(threshold, columns, rows, visited, column + 1, row) +
                    movingCount(threshold, columns, rows, visited, column - 1, row) +
                    movingCount(threshold, columns, rows, visited, column, row + 1) +
                    movingCount(threshold, columns, rows, visited, column, row - 1);
        }
        //循环的截止条件是已经（坐标不存在或者已经被访问过），当所有的满足要求的节点都被访问的时候就可以退递归
        return count;
    }

    /**
     * 判断机器人时候进入坐标（row,column）
     *
     * @param threshold 阀值
     * @param columns   列长
     * @param rows      行宽
     * @param visited   用于记录微爱之是否被访问过
     * @param row       当前行
     * @param column    当前列
     * @return 时候能进入的结果
     */
    private static boolean check(int threshold, int columns, int rows, boolean[] visited, int row, int column) {
        return row >= 0 && column >= 0 && !visited[column * row + column] && getSumOfDigital(column, row) <= threshold &&
                column <= columns && row <= rows;
    }


    /**
     * 获取
     *
     * @param column  列
     * @param row 行
     * @return
     */
    private static int getSumOfDigital(int column, int row) {
        int sum = 0;
        while (column != 0) {
            sum += column % 10;
            column = column / 10;
        }

        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        return sum;
    }
}
