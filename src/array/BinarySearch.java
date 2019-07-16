package array;

/**
 * @author panghu
 * @title: BinarySearch  对于有序数列才能使用二分查找法（排序的作用）
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-16 下午7:31
 */
public class BinarySearch {

    /**
     * 二分查找  使用递归实现
     * @param arr  传入的有序数组
     * @param key 寻找的值
     * @return 找到的位置
     */
    public static int commonBinarySearch(int[] arr,int key){

        int low = 0;
        int high = arr.length-1;
        int middle = 0;

        if (key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while (low <= high){
            middle = (low +high)/2;
            //如果目标值比middle大
            if (arr[middle] < key){
                low = middle+1;
            }
            //如果目标值比索引middle对应的值小
            else if (arr[middle] > key){
                high = middle-1;
            }else {
                return middle;
            }

        }
        return -1;

    }

    /**
     * @param arr  有序数组
     * @param key 目标值
     * @param low 寻找的起始位置
     * @param high  寻找的结束位置
     * @return 目标值所在的索引
     */
    public static int recursionBinarySearch(int[] arr,int key,int low,int high) {

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        //关键字在右边
        if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        }
        //关键字在中间值的左边
        else if (arr[middle] > key){
            return recursionBinarySearch(arr,key,low,middle-1);
        }else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int key = 3;
        int position = recursionBinarySearch(arr,key,0,arr.length - 1);

//        int position = commonBinarySearch(arr, key);
        if(position == -1){
            System.out.println("查找的是"+key+",序列中没有该数！");
        }else{
            System.out.println("查找的是"+key+",找到位置为："+position);
        }
    }

}
