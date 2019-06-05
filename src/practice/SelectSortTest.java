package practice;

import org.junit.Test;
import sort.PublicMethod;

/**
 * @author panghu
 * @title: SelectSortTest
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-1 下午7:51
 */
public class SelectSortTest {

    //选择排序
    public static void selectSort(int[] arr){

        for (int i=0;i<arr.length;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<=arr[minIndex]){
                    minIndex = j;
                }
            }
            PublicMethod.swap(arr,i,minIndex);
        }

    }

    //插入排序
    public static void insertSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=i;j>0;j--){
                if (arr[j+1]<arr[j]){
                    PublicMethod.swap(arr,j,j+1);
                }
            }
        }
    }

    @Test
    public void selectSortTest(){
        int[] arr = {1,4,7,2,5,8,3,6,9};
        insertSort(arr);
        for (int i:arr
             ) {
            System.out.print(" "+i);
        }
    }

}
