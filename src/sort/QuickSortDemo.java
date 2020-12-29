package sort;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 23:22 2020/8/12
 * @Modified By:
 */
public class QuickSortDemo {

    public void sort(int left,int right,int[] arr){
        if (left >= right) {
            return;
        }
        int partition = partition(left,right,arr);
        sort(left,partition,arr);
        sort(partition+1,right,arr);
    }

    public int partition(int left,int right,int[] arr) {
        // 记录起始交换位置
        int index = left;

        int value = arr[left];

        for(int i = left + 1;i <= right;i ++ ) {
            if (arr[i] <= value) {
                swap(++index,i,arr);
            }
        }
        swap(left,index,arr);

        return index;
    }

    public static void swap( int x, int y,int[] arr){
        int temp;
        temp  = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    @Test
    public void test(){
        int[] a = { 12,15,1,18,2,35,30,11};
        sort( 0,a.length-1,a);
        System.err.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
    }

}
