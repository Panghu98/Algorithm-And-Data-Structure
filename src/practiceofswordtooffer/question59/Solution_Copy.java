package practiceofswordtooffer.question59;

import list.LinkedListQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 23:16 2020/3/14
 * @Modified By:
 */
public class Solution_Copy {

    @Test
    public void test() {

        int[] num = {2,3,2,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(num,size);
        System.err.println(list.toString());
    }

    private ArrayList<Integer> maxInWindows(int[] num, int size) {

        LinkedList<Integer> deque = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            if (deque.size() > 3) {
                int oldMax = deque.getLast();
                if (num[i] > oldMax) {
                    deque.add(num[i]);
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
            }else {
                if (deque.isEmpty()) {
                    deque.add(num[i]);
                }else {
                    if (deque.getLast() > num[i]) {
                        deque.add(deque.getLast());
                    }else {
                        deque.add(num[i]);
                    }
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

}
