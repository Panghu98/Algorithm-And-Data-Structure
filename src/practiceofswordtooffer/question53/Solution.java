package practiceofswordtooffer.question53;

/**
 * @author dengg
 */
public class Solution {

    public int GetNumberOfK(int[] array , int k) {
        int number = 0;
        if (array != null && array.length !=0 ){
            int first = getFirstK(array,k,0,array.length-1);
            int last = getFirstK(array,k,0,array.length-1);

            if (first > -1 && last > -1) {
                number = last-first-1;
            }
        }

        return number;
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

    private int getLastK(int[] array,int k,int start,int end) {
        //结束判断
        if (start >= end) {
            return -1;
        }

        int middle = (start + end) / 2;
        int middleData = array[middle];

        if (middleData == k) {
            if (middle < array.length-1 && array[middle - 1] != k) {
                return middle;
            } else if (middle == array.length -1) {
                return middle;
            } else {
                start = middle+1;
            }
        }

        if (middleData > k){
            end = middle-1;
        }else {
            start = middle+1;
        }

        return getFirstK(array, k, start, end);
    }

}
