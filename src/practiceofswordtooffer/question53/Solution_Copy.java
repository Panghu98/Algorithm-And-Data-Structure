package practiceofswordtooffer.question53;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:45 2020/3/13
 * @Modified By:
 */
public class Solution_Copy {

    public int GetNumberOfK(int[] array , int k) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int number = 0;

        int first = getFirstK(array,k,0,array.length-1);
        int last = getLastK(array,k,0,array.length-1);

        if (first > -1 && last > -1) {
            number = last-first+1;
        }

        return number;
    }

    private int getLastK(int[] array,int k,int start,int end) {
        //结束判断
        if (start >= end) {
            return -1;
        }
        int middle = (start + end)/2;
        if (array[middle] == k) {
            if (middle < array.length -1 && array[middle+1] > k ) {
                return middle;
            }else if (middle == array.length -1) {
                return middle;
            }else {
                start = middle + 1;
            }
        }else {
            if (array[middle] > k) {
                end = middle - 1;
            }else {
                start = middle + 1;
            }
        }


        return getLastK(array, k, start, end);
    }

    private int getFirstK(int[] array,int k,int start,int end) {
        //结束判断
        if (start >= end) {
            return -1;
        }

        int middle = (start + end) / 2;
        int middleData = array[middle];

        if (middleData > k) {
            return getFirstK(array, k, start,middle-1);
        } else if (middleData < k) {
            return getFirstK(array, k, middle+1, end);
            //相等的情况
        } else {
            if (middle > 0 && array[middle - 1] != k) {
                return middle;
            } else if (middle == 0) {
                return middle;
            } else {
                return getFirstK(array, k, start, middle - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{1,2,3,3,3,3,3,3,4};
        int k= 3;
        System.out.println(GetNumberOfK(arr,k));
    }

}
