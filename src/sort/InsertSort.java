package sort;

import org.junit.Test;

/**
 * @author panghu
 * @title: InsertSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-26 下午7:59
 */
public class InsertSort {

    /*
    * 算法复杂度 o n*2
    * 排序的思想
    * 为当前位置的元素选择合适的位置
    * 选择的方法是通过和自己左边的元素进行对比  如果比左边小的话就进行交换
    * */

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                        swap(arr,j,j-1);
                }
            }
        }
    }



    public static void swap(int[] arr, int x, int y){
        int temp;
        temp  = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
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
