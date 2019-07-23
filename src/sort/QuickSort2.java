package sort;

import org.junit.Test;

import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: QuickSort2
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-22 下午10:27
 */
public class QuickSort2 {

    private void quickSort(int[] arr, int l, int r) {

        if (l >= r){
            return;
        }
        int position = partition(arr,l,r);
        quickSort(arr,l,position-1);
        quickSort(arr,position+1,r);
    }

    int partition(int[] arr, int left, int right){
        int ranNum = left + (int)(Math.random()*(right-left+1));
        //把随机数作为索引,将索引对应值与最后一位值 right 交换
        swap(arr,right,ranNum);
        // arr[left+1...i) <= v; arr(j...right] >= v
        int value = arr[left];

        int i = left+1, j = right;
        while( true ){
            while( i <= right && arr[i] < value) {
                i ++;
            }

            while( j >= left+1 && arr[j] > value ) {
                j --;
            }

            if( i > j ) {
                break;
            }

            swap(arr,i,j);
            i ++;
            j --;
        }

        swap(arr, left, j);

        return j;
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
