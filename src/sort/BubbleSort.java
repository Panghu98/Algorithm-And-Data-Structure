package sort;

import org.junit.Test;

/**
 * @author: panghu
 * @Description: 冒泡算法
 * @Date: Created in 22:10 2020/2/29
 * @Modified By:
 */
public class BubbleSort {

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

    public static void sort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-1-i; j++) {
                //将大数向后移动
                if (arr[j +1] < arr[j]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    @Test
    public void test(){
        int[] arr = { 49, 38, 65, 97, 76, 13, 27, 50 };
        sort(arr);
        System.out.println("排好序的数组：");
        for (int e : arr) {
            System.out.print(e+" ");
        }
    }

}
