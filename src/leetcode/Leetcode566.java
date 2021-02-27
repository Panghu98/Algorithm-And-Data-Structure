package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:27 2021/2/17
 * @Modified By:
 */
public class Leetcode566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        // r代表的是行数，c代表的是列数

        int[][] result = new int[r][c];

        int index = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                index = i * r + j;
                result[i][j] = getValue(nums,index);
            }
            
        }

        return result;
    }

    private int getValue(int[][] nums,int index) {
        int rows = nums.length;
        int columns = nums[0].length;

        int row = index / rows;
        int column = index % columns;

        return nums[row][column];

    }

    @Test
    public void test() {

    }

}
