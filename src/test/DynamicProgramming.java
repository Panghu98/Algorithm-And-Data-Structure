package test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:30 2020/2/28
 * @Modified By:
 */
public class DynamicProgramming {

    private static int[][] triangle = {
            {2,0,0,0},
            {3,4,0,0},
            {6,5,7,0},
            {4,1,8,3}
    };

    public static int traverse() {
        int row = 4;
        //将最后一行赋值到mini
        int[] mini = triangle[row-1];
        //从倒数第二行开始，因为最后一行已经有值了
        for (int i = row-2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length-1; j++) {
                //mini[j] -- 代表的是该行最小的元素
                //Math.min(mini[j] ,mini[j+1]) 下一行的最小值
                mini[j] = triangle[i][j] + Math.min(mini[j] ,mini[j+1]);
            }
        }

        return mini[0];
    }

    public static void main(String[] args) {
        int result = traverse();
        System.out.println(result);
    }

}
