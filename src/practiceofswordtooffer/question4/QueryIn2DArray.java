package practiceofswordtooffer.question4;

public class QueryIn2DArray {

    static int[][] arr = {{1,2,8,9},{1,4,9,12},{4,7,10,13},{6,8,14,15}};

    static boolean findNumber(int[][] arr,int num,int rows,int columns){

        if (rows ==0 || columns == 0){
            return false;
        }

        int column = columns-1;
        int row = 0;

        //循环结束条件
        while (column >= 0 && row < rows){

            if (arr[column][row] == num){
                return true;
            }else if (arr[column][row] < num){
                row++;
            } else {
                column --;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        System.err.println(findNumber(arr,11,4,4));
    }

}
