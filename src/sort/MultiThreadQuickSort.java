package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: MultiThreadQuickSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-19 下午8:46
 */
public class MultiThreadQuickSort{

    //获取当前机器处理器的数目
    private static final int N = Runtime.getRuntime().availableProcessors();



    public static void main(String[] args)  throws Exception{
        int[] array = new int[12];
        Random random = new Random(10);
        for (int i = 0; i < 12; i++) {
            int num = random.nextInt(2000)+1;
            array[i] = num;
        }
        for (int i:array
        ) {
            System.out.print(i+" ");
        }
        long start = System.nanoTime();
        System.out.println();
        System.out.println("排序之前的数组");
        //创建执行排序线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CountDownLatch count = new CountDownLatch(4);
        try {
            int[] allArray = new int[array.length];
            for (int i = 0; i < 4; i++) {
                int[] subArray = Arrays.copyOfRange(array, i * 3, (i + 1) * 3);
                FutureTask<int[]> futureTask = new FutureTask<>(new Sort(subArray, 0, subArray.length - 1, count));
                executor.submit(futureTask);
                int[] temp = futureTask.get();
                for (int j = 0; j < temp.length; j++) {
                allArray[i*3 + j] = temp[j];
                }
            }
            count.await();
            CountDownLatch count2 = new CountDownLatch(1);
            //结果合并
            FutureTask<int[]> futureTask2 = new FutureTask<>(new Sort(allArray, 0, allArray.length - 1, count2));
            executor.submit(futureTask2);
            count2.await();
            int[] result = futureTask2.get();
            long end = System.nanoTime();
            System.err.println("排好序的数组：");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println("\n排序算法总耗时"+(end-start)+"  ns");

        }finally {
            //一定要记得关闭线程池
            executor.shutdown();
        }
    }

    /**
     * 快速排序法实现类
     */
    static class Sort implements Callable<int[]>{
        int[] array;
        int left,right;
        CountDownLatch count;

        //排序算法构造方法

        public Sort(int[] array, int left, int right, CountDownLatch count) {
            this.array = array;
            this.left = left;
            this.right = right;
            this.count = count;
        }


        @Override
        public int[] call() throws Exception {
            quickSort(array,left,array.length-1);
            count.countDown();
            return array;
        }

        private void quickSort(int[] arr, int l, int r) {

            if (l >= r){
                return;
            }
            int position = partition(arr,l,r);
            quickSort(arr,l,position-1);
            quickSort(arr,position+1,r);
        }

        /*
         * 对arr[l...r]部分进行partition操作
         * 返回position,是的arr[l...p-1]<arr[p],arr[p+1...r]>arr[p]
         * */
        public static int partition(int[] arr,int left,int right){

            int value = arr[left];

            int position = left;
            //这里的right值是最右边的值 arr[right]是有效的
            for (int i=left+1;i<=right;i++){
                if (arr[i] < value){
                    /*
                     * 相关的操作
                     * 1.比初始位置大的数都放在初始位置的右边一个,放一个position的位置增加一
                     * */
                    swap(arr,i,++position);
                }
            }

            //走到这一步的时候  arr[l]存放的是分解值,arr[position]存放的是小于分界值
            //自我感觉这一步  有一种一举两得,即将分界值的位置移到了正确位置,也将左值放在了左边
            swap(arr,left,position);
            return position;

        }
    }

}
