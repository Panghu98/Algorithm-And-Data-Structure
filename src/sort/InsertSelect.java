package sort;

import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: InsertSelect
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-26 下午7:59
 */
class InsertSelect {

    /*
    * 算法复杂度 o n*2
    * 排序的思想
    * 为当前位置的元素选择合适的位置
    * 选择的方法是通过和自己左边的元素进行对比  如果比左边小的话就进行交换
    * */


    static int[] insertSort(int[] arr){
        for (int i = 0; i < arr.length - 1;i++){
            for (int j = i+1;j > 0 ;j--){
                if (arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
        return arr;
    }

}
