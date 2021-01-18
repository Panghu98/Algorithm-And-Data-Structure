package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:17 2021/1/17
 * @Modified By:
 */
public class Leetcode1232 {

    private int startX,startY;

    private double slope;

    public boolean checkStraightLine(int[][] coordinates) {
        int[] startPoint = coordinates[0];
        // 记录起始位置
        startX = startPoint[0];
        startY = startPoint[1];

        int[] secondPoint = coordinates[1];
        int secondX = secondPoint[0],secondY = secondPoint[1];
        int temp = secondY - startY;
        if (temp == 0) {
            slope = Double.MAX_VALUE;
        }else {
            slope = (secondX - startX) * 1.0 / temp;
        }

        for (int i = 2; i < coordinates.length; i++) {
            int[] point = coordinates[i];
            int x = point[0];
            int y = point[1];

            if ( !validLine(x,y)) {
                return false;
            }
        }
        return true;
    }

    boolean validLine(int currentX,int currentY) {

        double currentSlope;

        int temp = currentY - startY;
        if (temp == 0) {
            currentSlope = Double.MAX_VALUE;
        }else {
            currentSlope =  (currentX - startX) * 1.0 / temp;
        }

        return Math.abs(currentSlope - slope) < 0.0000001;

    }

    @Test
    public void test() {
        int[][] coordinates =
                new int[][]{{1,2},{2,3},{3,4},{3,5},{5,6},{6,7}};
        System.err.println(checkStraightLine(coordinates));
    }

}
