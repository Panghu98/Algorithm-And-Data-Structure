package sort;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static sort.PublicMethod.getArr;
import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: SelectSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-26 下午7:00
 */
public class SelectSort {


    /*
    算法复杂度 o n*2
    * 从第一个开始寻找最值
    * 寻找的方式遇到比它小的值就进行记录 较小值的下标  这样遍历一遍下来 记录的就是最小值的
    * */


    /*
    * 第一步  找到最小值，记录位置
    * 第二步  交换位置
    * */

    static int[] selectSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            //假设最小值所在的位置在当前位置
            int minIndex = i;
            for (int j = i+1;j < arr.length;j++)
            {
                if (arr[j] < arr [minIndex]){
                    //重新记录最小值的位置
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
        return arr;
    }

}
