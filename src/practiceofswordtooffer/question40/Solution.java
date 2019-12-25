package practiceofswordtooffer.question40;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        if (input == null || k > input.length || k <= 0) {
            throw new IllegalArgumentException("参数错误");
        }
        int start = 0;
        int end = input.length -1;
        //一致排序操作直到 分界点为k
        int partition = partition(input,start,end);
        while (partition != k-1) {
            if (partition >= k - 1){
                end = partition -1;
                partition = partition(input,start,end);
            }else {
                start = partition +1;
                partition = partition(input,start,end);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;

    }


    //快排核心代码
    private int partition(int[] arr,int left,int right) {
        int value = arr[left];
        int position = left;
        for (int i = left+1; i <= right; i++) {
            if (arr[i] < value) {
                position ++;
                swap(arr,position,i);
            }
        }

        swap(arr, left, position);
        return position;
    }

    private void  swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> arrayList = solution.GetLeastNumbers_Solution(arr,k);
        System.err.println(arrayList);
    }

}
