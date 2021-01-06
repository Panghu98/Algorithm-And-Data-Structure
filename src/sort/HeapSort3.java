package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:47 2021/1/5
 * @Modified By:
 */
public class HeapSort3 {

    /**
     * 堆排序的主要两步
     *  1.构建堆
     *  2.调整堆
     */

    /**
     * 构建大根堆
     * @param arr
     */
    private void heapInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            // 记录当前节点所在的索引
            int currentIndex = i;

            // 父亲节点
            int parentIndex = (currentIndex - 1) / 2;
            while (arr[currentIndex] > arr[parentIndex]) {
                swap(arr,parentIndex,currentIndex);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
        }
    }


    @Test
    public void test() {
        int[] ints = {3, 6, 8, 5, 7};
        heapSort(ints);
        System.err.println(Arrays.toString(ints));
    }

    /**
     * 交换数组当中的两个数字
     * @param arr
     * @param left
     * @param right
     */
    private void swap(int[] arr,int left,int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * 对已经进行大顶堆构建的堆进行处理
     * @param arr
     * @param size
     */
    private void heapify(int[] arr, int size) {
        int index = 0;

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                // 这里的index是滑动的
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            // 这里的判定结束就是定点已经是最大的了
            if (index == largestIndex) {
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }

    }

    private void heapify(int[] arr, int size,int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        while(leftIndex < size) {


            int largestIndex = leftIndex;
            if (arr[rightIndex] > arr[leftIndex] && rightIndex < size) {
                largestIndex = rightIndex;
            }

            // 结束
            if (arr[index] > arr[largestIndex]) {
                break;
            }

            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            leftIndex = 2 * index + 1;
            rightIndex = 2 * index + 2;

        }
    }


    public void heapSort(int[] arr) {
        //构造大根堆
        heapInsert(arr);
        int size = arr.length;
        while (size > 1) {
            //固定最大值
            swap(arr, 0, size - 1);
            size--;
            //构造大根堆
            heapify(arr, size,0);

        }

    }


}
