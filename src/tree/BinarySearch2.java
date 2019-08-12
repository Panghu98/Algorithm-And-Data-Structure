package tree;

/**
 * @author panghu
 * @title: BinarySearch2
 * @projectName algorithm-data-structure
 * @date 19-7-27 上午9:22
 */
public class BinarySearch2
{

    /**
     * 用于寻找目标值第一次出现的位置
     * @param arr 数组
     * @param target 目标值
     * @return 目标值第一次出现的位置,如果没有找到就是最接近目标值(左边)的位置
     */
    private static int floor(Comparable[] arr, Comparable target){

        //寻找比target小的最大索引(left设置为-1是因为有可能最左边的元素也有可能不是目标值)
        //与下面的right设置为arr.length是一样的性质
        int left = -1;
        int right = arr.length-1;

        while (left < right){
            //+1是防止溢出
            int mid = left + (right - left+1)/2;
            //中间值大于目标值  选择左边区域
            if (arr[mid].compareTo(target) >= 0){
                right = mid - 1;
            }else {
                left = mid;
            }

        }


        // 如果该索引+1就是target本身, 该索引+1即为返回值
        if( left + 1 < arr.length && arr[left+1] == target ) {
            return left + 1;
        }


        // 否则, 该索引即为返回值
        return left;

    }

    /**
     * 用于寻找目标值最后一次出现的位置
     * @param arr 数组
     * @param target 目标值
     * @return 目标值第一次出现的位置,如果没有找到就是最接近目标值(右边)的位置
     */
    private static int ceil(Comparable[] arr,Comparable target){

        //寻找比target大的最小索引
         int left = 0;
         int right = arr.length;
         while (left < right){
             //注意与上面去中间值的区别
             int mid = left + (right - left)/2;
             //中间值小于目标值
             if( arr[mid].compareTo(target) <= 0 ){
                 left = mid + 1;
             }else {
                 right = mid - 1;
             }
         }

         //如果索引-1就是目标值本上,该索引+1就是返回值
         if (right - 1 >= 0 && arr[right-1] == target ){
             return right-1;
         }
         //否则这个索引就是返回值
         return right;
    }

    public static void main(String[] args) {
        Comparable[] arr = {1,1,2,3,5,5,5,5,9};
        System.out.println(floor(arr,0));
        System.out.println(ceil(arr,0));
    }

}
