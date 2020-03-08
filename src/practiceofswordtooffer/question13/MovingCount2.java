package practiceofswordtooffer.question13;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 14:13 2020/3/3
 * @Modified By:
 */
public class MovingCount2 {

    public int movingCount(int rows,int columns,int k) {

        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;

        boolean[] visited = new boolean[rows*columns];
        return movingCount(k,rows, columns,visited,0,0,count);
    }

    public int movingCount(int threshold, int columns, int rows, boolean[] visited, int column, int row,int count) {
        if (check(column,row,columns,rows,visited,threshold)) {
            visited[column + row * columns] = true;
            count++;
            movingCount(threshold, columns, rows, visited, column+1, row, count);
            movingCount(threshold, columns, rows, visited, column, row+1, count);
            movingCount(threshold, columns, rows, visited, column-1, row, count);
            movingCount(threshold, columns, rows, visited, column, row-1, count);
        }

        return count;
    }

    public static void main(String[] args) {
        MovingCount2 movingCount = new MovingCount2();
        System.err.println(movingCount.movingCount(4,5,12));
    }

    boolean check(int column,int row,int columns,int rows,boolean[] visited,int k) {
        return valid(column, row, k) && column < columns && row < rows && !visited[column + row * columns] ;
    }



    boolean valid(int column,int row,int k) {
        int result = 0;
        while (column != 0) {
            result += column % 10;
            column = column/10;
        }

        while (row != 0) {
            result += row % 10;
            row = row/10;
        }

        return result <= k;
    }

}
