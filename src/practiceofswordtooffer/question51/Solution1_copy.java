package practiceofswordtooffer.question51;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:17 2020/3/7
 * @Modified By:
 */
public class Solution1_copy {
    private int cnt = 0;
    private void MergeSort(int[] array, int start, int end){
        if (start>=end) {
            return;
        }
        int mid = (start+end)/2;
        MergeSort(array,start,mid);
        MergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    private void merge(int[] array, int start, int mid, int end){
        int length = end -start +1;
        int tempArrIndex = 0;
        int[] temp = new int[length];
        //两个子数组的开始
        int i = start,j = mid + 1;
        while (i <= mid && j <= end) {
            //前面的子数组元素更大
            if (array[i] < array[j]) {
                temp[tempArrIndex++] = array[i++];
            }else {
                cnt = (cnt + (mid-i+1))%1000000007;
                temp[tempArrIndex++] = array[j++];
            }
        }
        while(i<= mid)
            temp[tempArrIndex++] = array[i++];
        while(j<=end)
            temp[tempArrIndex++] = array[j++];
        for(int l=0; l<tempArrIndex; l++){
            array[start+l] = temp[l];
        }
    }
    public int inversePairs(int [] array) {
        MergeSort(array, 0, array.length-1);
        return cnt;
    }

    @Test
    public void test() {
        int[] arr = new int[]{7,5,6,4};
        int result = inversePairs(arr);
        System.err.println(result);
    }
}
