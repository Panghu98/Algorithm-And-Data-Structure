package practice;

import org.junit.Test;
import sort.PublicMethod;

import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: QuickSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-27 下午6:46
 */
public class QuickSort {

    public void quickSort(int[] arr,int left,int right){

        if (left >= right){
            return;
        }
        int partition = partition(arr, left, right);
        quickSort(arr,left,partition-1);
        quickSort(arr,partition+1,right);


    }

    public static int partition(int[] arr, int left, int right){

        //记录起始的位置
        int start = left;

        for (int i=left+1;i<=right;i++){

            if (arr[i] < arr[left] ){

                swap(arr, i, ++start);

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
