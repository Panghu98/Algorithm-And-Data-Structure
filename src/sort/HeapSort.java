package sort;

import java.util.Arrays;

/**
 * @author panghu
 * @title: HeapSort
 * @projectName      堆排序   使用最大堆
 * @date 19-6-27 下午7:00
 */
public class HeapSort {


    /**
     * 已知arr[s...m]中记录的关键字除了arr[s]之外均满足堆的定义,该函数是为了使得arr[s..m]成为一个最大堆
     * 叶子节点上移  shift down操作
     * @param arr  传入数组名称
     * @param s 已经有序的起始位置
     * @param m 未有序位置
     */
    void heapAdjust(int[] arr,int s,int m){

        //s是最后一个非叶子节点
        int current = arr[s];

        for(int j= s*2 ;j <= m;j = s*2){

            if (j < m && arr[j] < arr[j+1]){
                // j为key较大的下标
                j++;
            }
            if (current >= arr[j]){
                break;
            }

            //上移到父节点
            arr[s] = arr[j];
            //  传出参数j s
            s = j;

        }

        //要放入的位置
        arr[s] = current;

    }

    int[] arr;

     void heapSort(int[] arr){

        //对数组进行建堆操作,就是从最后一个非叶子节点进行筛选的结果
        //(arr.length-1)/2   父节点
        for (int i = (arr.length-1)/2;   i>0;  i--){
            heapAdjust(arr,i,arr.length-1);
        }
        System.out.println("--------建堆完成-------");

        System.err.print("堆中的数据为:  ");

        //输出队列  数组的下标从1开始
        outputArr(1);

        for (int i = arr.length-1; i>1; i--){

            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapAdjust(arr,1,i-1);

        }

         System.out.println();
         System.out.println(Arrays.toString(arr));

    }


    void outputArr(int i){

        if (i <= arr.length-1){
            System.out.print(arr[i]+" ");
            //输出左子节点
            outputArr(i*2);
            //输出右子节点
            outputArr(i*2+1);

        }

    }

    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();

        //0下标放的是数组长度
        int[] arr = {8,23,45,9,40,73,12,13,72};
        heapSort.arr = arr;
        heapSort.heapSort(arr);


    }

}
