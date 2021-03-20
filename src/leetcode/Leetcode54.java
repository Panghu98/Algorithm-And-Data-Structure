package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:57 2021/3/20
 * @Modified By:
 */
public class Leetcode54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }

        int left = 0;
        int right = matrix[0].length -1;
        int up = 0;
        int down = matrix.length -1;

        while (true) {
            for (int i = left; i <= right ; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }

            for (int i = up; i <= down ; i++) {
                list.add(matrix[i][right]);
            }

            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left ; i--) {
                list.add(matrix[down][i]);
            }
            down--;

            if (down < up) {
                break;
            }

            for (int i = down; i >= up ; i--) {
                list.add(matrix[i][left]);
            }

            left++;
            if (left > right) {
                break;
            }


        }

        return list;

    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

}
