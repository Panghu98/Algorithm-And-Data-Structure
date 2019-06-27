package practice;

import org.junit.Test;

/**
 * @author panghu
 * @title: MergeSortTest
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-5 下午6:24
 */
public class MergeSortTest {

   void mergeSort(int[] arr,int left,int right){
       if(left < right){
           int mid = (left+right)/2;
           mergeSort(arr,left,mid);
           mergeSort(arr,mid+1,right);
           merge(arr,left,mid,right);
       }
   }

   void merge(int[] arr,int left,int mid,int right){

       //创建临时数组
       int[] temp = new int[arr.length];

       //创建数组下标
       int p1=left,p2 = mid+1,k = left;

       while (p1 <= mid && p2 <= right){
           if (arr[p1] >= arr[p2]){
               temp[k++] = arr[p2++];
           }else {
               temp[k++] = arr[p1++];
           }
       }

       while (p1 <= mid){
           temp[k++] = arr[p1++];
       }

       while (p2 <= right){
           temp[k++] = arr[p2++];
       }

       System.arraycopy(temp,left,arr,left,right+1-left);

   }

    @Test
    public void test(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a)
            System.out.print(e+" ");
    }

}
