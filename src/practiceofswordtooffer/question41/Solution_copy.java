package practiceofswordtooffer.question41;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:38 2020/3/8
 * @Modified By:
 */
public class Solution_copy {

    //小顶堆，用于存放大数
    PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();

    //小顶堆，用于存放小数 (进行的排序条件是大数在前面 -- 需要将大数放入小顶堆)
    PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //记录个数（用于判断是奇数还是偶数）
    private int count = 0;

    public void insert(int num){
        count++;
        //判断是不是偶数
        boolean boolEven = (count & 1) == 0;

        maxHeap.add(num);
        //如果偶数
        if (boolEven) {
            minHeap.add(maxHeap.poll());
        }

    }

    public Double getMedian() {

        //防止count=0时出现空指针异常
        if (count == 0) {
            return 0.0;
        }

        //如果是偶数
        if ((count & 1) == 0) {
            return (minHeap.peek() + maxHeap.peek() )/ 2.0;
        }else {
            return Double.valueOf(maxHeap.peek());
        }
    }

    @Test
    public void test() {
        insert(5);
        System.out.println(getMedian());
        insert(4);
        System.out.println(getMedian());
        insert(3);
        System.out.println(getMedian());
        insert(3);
        System.out.println(getMedian());
    }

}
