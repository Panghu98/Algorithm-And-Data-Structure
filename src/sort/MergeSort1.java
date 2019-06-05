package sort;

import org.junit.Test;

/**
 * @author panghu
 * @title: MergeSort2
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-5 下午7:20
 *
 * 针对于数组整体有序的情况下进行
 * 归并排序的优化
 * 这里还有第二种优化方式  就是在n小于一定的数值的时候 启用先选择排序的方式再排序
 */
public class MergeSort1 {

    public static void mergeSort(int[] arr,int start,int end){
        if (start<end){
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);

            //发生的改变的之后这一行
            if (arr[mid] > arr[mid+1]){
                merge(arr,start,mid,end);
            }
        }

    }

    private static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[arr.length];

        int p1=left,p2=mid+1,k=left;

        while (p1<=mid && p2<=right){
            if (arr[p1] <= arr[p2]){
                temp[k++] = arr[p1++];
            }
            else {
                temp[k++] = arr[p2++];
            }
        }

        while(p1<=mid){
            temp[k++] = arr[p1++];
        }

        while (p2<=right){
            temp[k++] = arr[p2++];
        }

        if (right + 1 - left >= 0) {
            System.arraycopy(temp, left, arr, left, right + 1 - left);
        }
    }

    @Test
    public void test(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
    }


}
