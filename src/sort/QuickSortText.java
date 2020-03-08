package sort;

import org.junit.Test;

import java.util.Random;

import static sort.PublicMethod.swap;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:08 2020/2/29
 * @Modified By:
 */
public class QuickSortText {

    public static void  quickSort(int[] arr,int left,int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition-1);
        quickSort(arr, partition+1, right);
    }

    private static int partition(int[] arr,int left,int right) {

        int value = arr[left];

        int position = left;

        int randomIndex =left + (new Random().nextInt(right-left));
        swap(arr,right,randomIndex);

        //注意是小于等于，需要计算到最右边
        for (int i = left+1; i <= right; i++) {
            if (arr[i] < value) {
                ++position;
                swap(arr,position,i);
            }
        }

        swap(arr,left,position);
        return position;

    }

    /**
     * 没有办法想C语言的指针那样直接通过指针交换,可以通过数组或者是对象属性来交换
     * @param arr  数组名
     * @param x 下标
     * @param y 下标
     */
    public static void swap(int[] arr, int x, int y){
        int temp;
        temp  = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
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
