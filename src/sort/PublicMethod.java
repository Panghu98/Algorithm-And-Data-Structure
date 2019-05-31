package sort;

import java.util.Random;

import static sort.InsertSelect.insertSort;

/**
 * @author panghu
 * @title: PublicMethod
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-27 上午8:06
 */
class PublicMethod {

    static int[] getArr(int length){
        int[] arr = new int[length];
        Random random = new Random(0);
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100)+1;
        }
        return arr;
    }


    /**
     * 没有办法想C语言的指针那样直接通过指针交换,可以通过数组或者是对象属性来交换
     * @param arr  数组名
     * @param x 下标
     * @param y 下标
     */
    static void swap(int[] arr, int x, int y){
        int temp;
        temp  = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
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

        long start = System.nanoTime();

        int[] result =  insertSort(arr);
        for (int a:result
        ) {
            System.out.print(a + " ");
        }

        long end = System.nanoTime();

        System.out.println("\n排序算法总耗时"+(end-start)+"  ns");


    }

}
