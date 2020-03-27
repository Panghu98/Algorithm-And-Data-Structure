package leetcode_tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @Date: Created in 22:52 2020/3/27
 * @Modified By:
 */
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null) {
            return list;
        }
        int left = 0;
        int above = 0;
        int right = matrix[0].length - 1;
        int below = matrix.length -1;

        // 不应该在While条件里面进行判断，而是应该在每次边界变化之后
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[above][i]);
            }
            above++;
            if (above > below) {
                break;
            }

            for (int i = above; i <= below; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left ; i--) {
                list.add(matrix[below][i]);
            }
            below--;
            if (below < above) {
                break;
            }

            for (int i = below;i >= above;i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left >right ) {
                break;
            }
        }

        return list;
        
    }

}
