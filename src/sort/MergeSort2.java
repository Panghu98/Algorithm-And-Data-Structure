package sort;

import org.junit.Test;

/**
 * @author panghu
 * @title: MergeSort2
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-31 下午4:08
 */
public class MergeSort2 {

    public static void mergeSort(int[] arr,int start,int end){
        int mid = (start+end)/2;
        if(start<end){
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right){
        int p1=left,p2=mid+1,k=left;
        int[] temp = new int[arr.length];

        while (p1<=mid && p2<=right){
            if (arr[p1]<arr[p2]){
                temp[k++] = arr[p1++];
            }else   {
                temp[k++] = arr[p2++];
            }
        }

        while(p1<=mid){
            temp[k++] = arr[p1++];
        }
        while (p2<=right){
            temp[k++] = arr[p2++];
        }

        for (int i=left;i<=right;i++){
            arr[i] = temp[i];
        }
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
