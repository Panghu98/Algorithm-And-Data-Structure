package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:22 2021/2/24
 * @Modified By:
 */
public class Leetcode832 {


    @Test
    public void test() {
//        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{
//                {1, 1,0, 0}, {1,0, 0, 1}, {1, 0, 1, 0}})));
        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{
                {1}})));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            convertArr(A[i]);
        }

        return A;
    }

    /**
     * @param array
     */
    private void convertArr(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right && right >= 0 && left <= array.length -1) {
            int temp =  array[left] ^ 1;
            array[left] =  array[right] ^1;
            array[right] = temp;
            left++;
            right--;
        }
    }

}
