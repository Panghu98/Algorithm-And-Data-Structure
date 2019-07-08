package queue;

import java.util.Random;

/**
 * @author panghu
 * @title: Main
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-8 上午10:47
 */
public class Main {

    // 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0 ; i < opCount ; i ++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        //ArrayQueue, time: 4.233839411 s
        //LoopQueue, time: 0.0126113 s
        //时间的差异主要是在出队这个的区别,在ArrayQueue中出队后整个队列都会发生移动

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }
}