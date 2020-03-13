package test;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 8:29 2020/3/13
 * @Modified By:
 */
public class QuickSort {

    public void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr,left,partition-1);
            quickSort(arr,partition+1,right);
        }
    }

    /**
     * 返回正确位置的下标
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] arr,int left,int right) {
        int value = arr[left];
        int swapIndex = left;
        for (int i = left+1; i <= right; i++) {
            if (arr[i] < value) {
                swapIndex++;
                //注意防止越界
                swap(arr,swapIndex,i);
            }
        }

        swap(arr,left,swapIndex);
        return swapIndex;
    }

    private void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        quickSort(a,  0,a.length-1);
        System.err.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
    }
}
;