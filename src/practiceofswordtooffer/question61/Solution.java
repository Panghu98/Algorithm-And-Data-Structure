package practiceofswordtooffer.question61;

public class Solution {

    //1.把数组排序
    //2.统计数组中0的个数
    //3.统计排序之后的数组中相邻数字之间的空缺总数，如果空缺总数小于等于0的个数，则数组是连续的，否则是不连续的
    //4.注意：如果数组中非0数字重复出现，则肯定是不连续的

    public boolean isContinuous(int[] numbers) {
        //验证参数的合法性
        if (numbers == null ||numbers.length == 0) {
            throw new IllegalArgumentException("参数不合法");
        }

        //Arrays.sort(numbers);
        quickSort(numbers,0,numbers.length-1);
        //统计数组中0的个数
        int count0=0;
        for(int i=0;i<numbers.length-1 && numbers[i]==0;i++) {
            count0++;
        }

        //统计数组中相邻数字之间的空缺总数
        int countGap=0;


        //分别表示两个相邻的元素（从不为0的位置开始）
        int low=count0;
        int high=low+1;

        while(high<numbers.length){
            //数组中存在相邻两元素相同，则不可能为连续数组
            if(numbers[low]==numbers[high]){
                return false;
            }else{
                countGap+=numbers[high]-numbers[low]-1;
                low++;
                high++;
            }
        }
        return count0 >= countGap;
    }


    /**
     * 快速排序算法核心
     * @param a
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] a, int low, int high) {
        int privokey = a[low];
        while (low < high) {
            while (low < high && a[high] >= privokey)
                high--;
            swap(a, low, high);
            while (low < high && a[low] <= privokey)
                low++;
            swap(a, low, high);
        }
        return low;
    }

    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int privocLoc = partition(a, low, high);
            quickSort(a, low, privocLoc - 1);
            quickSort(a, privocLoc + 1, high);
        }
    }

    private void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}
