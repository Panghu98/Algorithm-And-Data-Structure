package practiceofswordtooffer.question47;

/**
 * @author dengg
 */
public class GreatestGift {

    /**
     * 礼物的最大价值实现方法 -- 动态规划
     * @param arr 数组
     * @param columns 列数
     * @param rows 行数
     * @return 最大价值
     */
    public static int getMaxValue(int[] arr,int columns,int rows) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (arr.length != columns * rows) {
            throw new IllegalArgumentException();
        }

        //辅助数组
        int[] assistArr = new int[columns*rows];
        assistArr[0] = arr[0];
        //横向边界动态规划赋值操作
        for (int i = 1; i < columns; i++) {
            assistArr[i] = assistArr[i-1] + arr[i];
        }
        
        //纵向边界动态规划赋值操作
        for (int i = 1; i < rows; i++) {
            assistArr[i*columns + i] = assistArr[(i -1) * columns + i] + arr[i*columns + i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                assistArr[columns * i + j] = Math.max(assistArr[columns * (i-1) + j],assistArr[columns * i + j-1]) + arr[columns * i + j];
            }
        }

        return assistArr[rows*columns -1]+arr[rows*columns -1];
        
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,10,3,8,12,2,9,6,5,7,4,11,3,7,16,5};
        System.err.println(getMaxValue(arr,4,4));
    }

}
