package sort;

import java.util.Random;

/**
 * @author panghu
 * @title: SelectSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-26 下午7:00
 */
public class SelectSort {

    private static int[] getArr(int length){
        int[] arr = new int[length];
        Random random = new Random(0);
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100)+1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int length = 20;
        int[] arr = getArr(length);
        System.out.println("排序前：");
        for (int a:arr
        ) {
            System.out.print(a + " ");
        }
        System.out.println("\n排序后：");
        int[] result =  selectSort(arr);
        for (int a:result
             ) {
            System.out.print(a + " ");
        }
    }

    /*
    * 第一步  找到最小值，记录位置
    * 第二步  交换位置
    * */

    private static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
                swap(arr,minIndex,i);
            }
        }
        return arr;
    }

    private static void swap(int[] arr,int x,int y){
        int temp;
        temp  = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
