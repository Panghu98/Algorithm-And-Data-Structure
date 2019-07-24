package sort;

import org.junit.Test;

import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: QuickSort3
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-23 下午2:02
 */
public class QuickSort3 {

    private void quickSort(int[] arr, int l, int r) {

        if (l >= r){
            return;
        }
        int position = partition(arr,l,r);
        quickSort(arr,l,position-1);
        quickSort(arr,position+1,r);
    }

    int partition(int[] arr,int left,int right){

        int ranNum = left + (int)(Math.random()*(right-left+1));
        //把随机数作为索引,将索引对应值与最后一位值 right 交换
        swap(arr,right,ranNum);
        // arr[left+1...i) <= value; arr(j...right] >= value
        int value = arr[left];
        // 将<v的分界线的索引值lt初始化为第一个元素的位置（也就是<v部分的最后一个元素所在位置）
        int lt = left;
        //将>value的分界线的索引值gt初始化为最后一个元素right的后一个元素所在位置
        // （也就是>value部分的第一个元素所在位置）
        int gt = right+1;
        // 将遍历序列的索引值i初始化为 left+1
        int i = left+1;
        while (i < gt){
            if (arr[i] < value){
                swap(arr, lt+1, i);
                //移动指针
                i++;
                //增加<value的部分
                lt++;
            }else if ( arr[i] > value){
                swap(arr,gt-1,i);
                //增加>value的部分
                gt--;
                //注意,这里不需要移动i,之前移动i是因为需要增加<value的部分
                //而保持=i部分不懂,所以i和lt都需要移动

            }else{
                //增加=v的部分
                i++;
            }
        }
        return i;

    }

    @Test
    public void test(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        quickSort(a,  0,a.length-1);
        System.err.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
    }

}
