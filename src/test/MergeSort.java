package test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 8:13 2020/3/13
 * @Modified By:
 */
public class MergeSort {

    public void mergeSort(int[] arr,int start,int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr,start,mid,end);
    }

    public void merge(int[] arr,int left,int mid,int right) {
        int[] temp = new int[right-left+1];
        int indexOfTempArr = 0;
        int indexLeft = left;
        int indexRight = mid + 1;
        while (indexLeft <= mid && indexRight <= right) {
            if (arr[indexLeft] < arr[indexRight]) {
                temp[indexOfTempArr++] = arr[indexLeft++];
            }else {
                temp[indexOfTempArr++] = arr[indexRight++];
            }
        }

        while (indexLeft <= mid) {
            temp[indexOfTempArr++] = arr[indexLeft++];
        }

        while (indexRight <= right) {
            temp[indexOfTempArr++] = arr[indexRight++];
        }

        if (right + 1 - left >= 0) {
            System.arraycopy(temp,0,arr,left,right-left+1);

        }

    }

    @Test
    public void test(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
    }

}
