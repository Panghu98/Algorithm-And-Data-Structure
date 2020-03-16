package practiceofswordtooffer.question59;


import java.util.ArrayDeque;

/**
 * @author panghu
 */
public class Solution2 {

    private ArrayDeque<InternalData> data = new ArrayDeque<>();
    private ArrayDeque<InternalData> maximum = new ArrayDeque<>();
    private class InternalData{
        int number;
        int index;
        public InternalData(int number,int index) {
            this.number=number;
            this.index=index;
        }
    }
    private int curIndex;

    public void push_back(int number) {
        InternalData curData = new InternalData(number,curIndex);
        data.addLast(curData);

        //当最大值队列不为空切最大值小于新加入的值的时候，删除这一步在实质上就相当于替换
        // 进行循环删除
        while(!maximum.isEmpty() && maximum.getLast().number<number) {
            maximum.removeLast();
        }

        //加入最大值
        maximum.addLast(curData);

        curIndex++;  //别漏了这句
    }

    public void pop_front() {
        if(data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if(curData.index==maximum.getFirst().index) {
            maximum.removeFirst();
        }
    }

    public int max() {
        if(maximum==null){
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return maximum.getFirst().number;
    }

    /*
    输入      2 4 2 5 3

            head  ->  tail
    data     2 4 2 5 3
    index    0 1 2 3 4

            head  ->  tail
    data     4 5 3
    index    1 3 4


     */

    public static void main(String[] args) {
        Solution2 testQueue = new Solution2();
        // {2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==2);
        // {2, 3}
        testQueue.push_back(3);
        System.out.println(testQueue.max()==3);
        // {2, 3, 4}
        testQueue.push_back(4);
        System.out.println(testQueue.max()==4);
        // {2, 3, 4, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==4);
        // {3, 4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==2);
        // {2, 6}
        testQueue.push_back(6);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2, 5}
        testQueue.push_back(5);
        System.out.println(testQueue.max()==6);
        // {6, 2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==6);
        // {2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5, 1}
        testQueue.push_back(1);
        System.out.println(testQueue.max()==5);
    }

}


