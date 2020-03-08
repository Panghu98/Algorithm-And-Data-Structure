package sort;

import org.junit.Test;

/**
 * @author panghu
 * @title: MergeSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-31 下午2:14
 * @Description 归并排序
 */
public class MergeSort {

    /**
     * 特点：分裂再合并  在最后一次的合并过程中  需要复制当前的数组
     * @param arr 数组名称
     * @return 排序后的数组
     */
      public static void mergeSort(int[] arr,int start,int end){
          //相当于子序列中只有一个元素时结束递归
          if (start<end){
              int mid = (start+end)/2;
              //这两个递归用于将数组划分成为最小的粒度
              mergeSort(arr,start,mid);
              mergeSort(arr,mid+1,end);
              merge(arr,start,mid,end);
          }

      }

      //两路归并算法，两个排序号的子序列合并成一个子序列
      private static void merge(int[] arr, int left, int mid, int right){
          //辅助数组
          int[] temp = new int[arr.length];

          //p1,p2是检测指针，k是存放指针
          int p1=left,p2=mid+1,k=left;

          //在两个都未到达边界之前
          while (p1<=mid && p2<=right){
              if (arr[p1] <= arr[p2]){
                  //先获取值，再自增
                  temp[k++] = arr[p1++];
              }
              else {
                  temp[k++] = arr[p2++];
              }
          }

          //这个循环是基于上面的排序，如果第一个序列未检测完毕，直接将后面的所有元素合并到序列当中
          while(p1<=mid){
              temp[k++] = arr[p1++];
          }

          while (p2<=right){
              temp[k++] = arr[p2++];
          }

          //这里只是完成了部分的排序，所以位置应该是这段范围内的left到right
          //注意这里是小于等于

          // 将临时数组的值赋值到arr
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
