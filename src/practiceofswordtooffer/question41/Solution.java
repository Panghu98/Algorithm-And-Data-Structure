package practiceofswordtooffer.question41;

import java.util.PriorityQueue;

public class Solution {

    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, (o1, o2) -> o2 - o1);


    //记录个数（用于判断是奇数还是偶数）
    private int count = 0;

    /**
     * 每次插入最小堆的是当前最大堆的最大的数
     * 每次插入最大堆的是当前最小堆中的最小的数
     * 这样保证小顶堆种的树永远大于等于大顶堆种的树
     * 中位数就可以方便地从两者的更节点中获取了
     * @param num
     */
    public void Insert(Integer num) {
        //用于判断奇数还是偶数,如果是奇数的话则成立
        if ((count & 1) == 0) {
            //将数据插入最大堆
            maxHeap.offer(num);
            //出队列
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else {
            //个数如果为奇数个，则先插入小顶堆，然后将小顶堆的树插入大顶堆
            //插入后变成偶数个
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count ++;
    }

    public Double GetMedian() {

        //防止count=0时出现空指针异常
        if (count == 0) {
            return 0.0;
        }

        //如果是偶数
        if ((count & 1) == 0) {
            return (minHeap.peek() + maxHeap.peek() )/ 2.0;
        }else {
            return Double.valueOf(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.err.println((i & 1) == 0);
        }
    }

}
