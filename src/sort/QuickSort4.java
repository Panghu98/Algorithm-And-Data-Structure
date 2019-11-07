package sort;

import org.junit.Test;

import static sort.PublicMethod.swap;

public class QuickSort4 {

    public void quickSort(int[] arr,int left,int right){

        if (left >= right){
            return;
        }
        int partition = partition(arr,left,right);
        quickSort(arr,left,partition-1);
        quickSort(arr,partition+1,right);
    }

    private int partition(int[] arr, int left, int right) {
        int start = left;
        for (int index = left +1;index <= right;index++){
            if (arr[index] < arr[left]){
                swap(arr,index,++start);
            }
        }
        swap(arr,left,start);
        return start;
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
