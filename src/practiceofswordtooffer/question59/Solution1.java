package practiceofswordtooffer.question59;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution1 {
    //2,3,4,2,6,2,5,1
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            //当长度大于滑动窗口长度的时候
            if (i >= size) {

                int oldMaxNum = deque.getLast();
                //如果新加入的值比双向队列中的最大值更大
                if (oldMaxNum < num[i]) {
                    deque.addLast(num[i]);
                }else {
                    //滑动窗口内的最大数值
                    int maxNum = num[i];

                    // 还是避免不了遍历滑动窗口
                    for (int j = i-1; j > i-size; j--) {
                        maxNum = Math.max(maxNum, num[j]);
                    }

                    //添加滑动窗口内的最大值
                    deque.addLast(maxNum);
                }

                // 2,3,4,2,6,2,5,1

                //长度小于滑动窗口的长度的时候
            }else{
                if (deque.size() != 0) {
                    //新加入的数字大于末尾数字
                    if (deque.getLast() < num[i]) {
                        deque.addLast(num[i]);
                    }else {
                        //新加入的数字小于滑动窗口的最大值，最大值不变
                        deque.addLast(deque.getLast());
                    }
                }else {
                    //双向队列为空的时候
                    deque.add(num[i]);
                }
            }
        }


        int counter = 0;

        while (!deque.isEmpty()) {
            Integer removeNum = deque.remove();
            if (counter >= 2) {
                list.add(removeNum);
            }
            counter++;
        }

        deque = null;
        return list;
    }

    @Test
    public void test() {

        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(num,size);
        System.err.println(list.toString());
    }

}
