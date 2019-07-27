package search;

/**
 * @author panghu
 * @title: BinarySearch
 * @projectName algorithm-data-structure
 * @date 19-7-26 下午9:58
 */
public class BinarySearch {

    /**
     * @param arr  传入的数组
     * @param n 数组的大小
     * @param target 需要查找的值
     * @return  返回的位置,如果没有找到就返回-1
     */
    static int binarySearch(int[] arr,int n,int target){
        //在arr[l..r]之中查找target
        int l = 0,r = n-1;
        while (l < r){

            //(l+r)/2会产生程序溢出的问题(其中一个值接近int的最大值的时候)
            int mid = l + (r-l)/2;
            if (arr[mid] == target){
                return mid;
            }

            if (target < arr[mid]){
                //在arr[l...mid-1]之中查找target
                r = mid - 1;
            }else {
                //在arr[mid+1..r]之中查找target
                l = mid + 1;
            }

        }
        return -1;
    }

    /**
     * 二分查找的递归实现方式
     * @param arr  数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     * @param target 目标值
     * @return
     */
    static int binarySearch2(int[] arr,int left,int right,int target){

        //在边界范围以内
        if (left < right){
            int mid = left+(right-left)/2;

            if(arr[mid] == target){
                return mid;
            }

            if (arr[mid] < target){
                return binarySearch2(arr,mid+1,right,target);
            }else {
                return binarySearch2(arr,left,mid-1,target);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,9};
        System.err.println(binarySearch2(arr,0,arr.length-1,3));
        System.out.println(binarySearch(arr,arr.length,3));
    }

}
