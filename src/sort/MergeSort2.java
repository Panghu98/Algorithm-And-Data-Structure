package sort;

import org.junit.Test;

/**
 * @author panghu
 * @title: MergeSort2
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-5 下午7:40
 */


/*
* 自底向上的归并排序方式
* 这么就不需要用到递归  而是使用到了 迭代
* */
public class MergeSort2 {

    void mergeSort(int[] arr,int n){
        // 1 2 4 8
        for (int size = 1;size<=n;size += size){
            for (int i=0;i+size<n;i+=(size*2)){
                //对于arr[i..i+size-1]和arr[i+size...i+2*size-1]进行归并
                int right = i+size*2-1>(n-1)?n-1: i+size*2-1;
                merge(arr,i,i+size-1,right);
            }
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
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
        mergeSort(a,  a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
    }

}
