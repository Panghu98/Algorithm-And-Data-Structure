package practiceofswordtooffer.question59;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 23:11 2020/3/15
 * @Modified By:
 */
public class Solution2_Copy {

    class InnerData{
        private int number;
        private int index;

        public InnerData(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    LinkedList<InnerData> data = new LinkedList<>();
    LinkedList<InnerData> max = new LinkedList<>();

    // 用于维护数据数组和最大值数组之间的关系
    private int curIndex;

    public void pushBack(Integer num) {
        InnerData dataElement = new InnerData(num,curIndex);
        data.add(dataElement);

        if (max.isEmpty()) {
            max.add(dataElement);
        }else {
            while (!max.isEmpty() && max.getLast().number < num) {
                max.removeFirst();
            }
            max.addLast(dataElement);
        }

        curIndex++;
    }

    public Integer popFirst() {
        if (data.isEmpty()) {
            return null;
        }

        InnerData dataElement = data.removeFirst();
        if (dataElement.index == max.getFirst().number) {
            max.removeFirst();
        }
        return dataElement.number;
    }

    public Integer max() {
        if(max==null){
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return max.getFirst().number;
    }

    @Test
    public void test() {
        pushBack(2);
        pushBack(4);
        pushBack(3);
        pushBack(2);
        max();
    }

}
