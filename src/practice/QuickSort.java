package practice;

import org.junit.Test;

import java.util.Random;

import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: QuickSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-17 上午9:53
 */
public class QuickSort {

    void quickSort(int[] arr,int left,int right){
        if (left>right){
            return;
        }
        int position = partition(arr,left,right);
        quickSort(arr,left,position-1);
        quickSort(arr,position+1,right);
    }

    int partition(int[] arr,int left,int right){

        int value  = arr[left];
        int position = left;

        for (int i = left+1; i < right+1; i++) {

            if (arr[i] < value){
                swap(arr,i,++position);
            }

        }
        swap(arr,left,position);
        return position;
    }
    @Test
    public void test(){
        int[] a = new int[12];
        Random random = new Random(12);
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(2000)+1;
            a[i] = num;
        }
        long start = System.nanoTime();
        System.out.println();
        quickSort(a,  0,a.length-1);
        long end = System.nanoTime();
        System.err.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
        System.out.println("\n排序算法总耗时"+(end-start)+"  ns");
    }

}
