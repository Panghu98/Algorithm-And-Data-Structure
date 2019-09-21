package queue;

import java.util.Random;

/**
 * @author panghu
 * @title: Main
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-8 上午10:47
 */
public class Main {

//    // 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
//    private static double testQueue(Queue<Integer> q, int opCount){
//
//        long startTime = System.nanoTime();
//
//        Random random = new Random();
//        for(int i = 0 ; i < opCount ; i ++) {
//            q.enqueue(random.nextInt(Integer.MAX_VALUE));
//        }
//        for(int i = 0 ; i < opCount ; i ++) {
//            q.dequeue();
//        }
//
//        long endTime = System.nanoTime();
//
//        return (endTime - startTime) / 1000000000.0;
//    }
//
//    public static void main(String[] args) {
//
//        int opCount = 100000;
//
//        //ArrayQueue, time: 4.233839411 s
//        //LoopQueue, time: 0.0126113 s
//        //时间的差异主要是在出队这个的区别,在ArrayQueue中出队后整个队列都会发生移动
//
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue, time: " + time1 + " s");
//
//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//        double time2 = testQueue(loopQueue, opCount);
//        System.out.println("LoopQueue, time: " + time2 + " s");
//    }
private static double testHeap(Integer[] testData, boolean isHeapify){

    long startTime = System.nanoTime();

    MaxHeap<Integer> maxHeap;
    if(isHeapify)
        maxHeap = new MaxHeap<>(testData);
    else{
        maxHeap = new MaxHeap<>();
        for(int num: testData)
            maxHeap.add(num);
    }

    int[] arr = new int[testData.length];
    for(int i = 0 ; i < testData.length ; i ++)
        arr[i] = maxHeap.extractMax();

    for(int i = 1 ; i < testData.length ; i ++)
        if(arr[i-1] < arr[i])
            throw new IllegalArgumentException("Error");
    System.out.println("Test MaxHeap completed.");

    long endTime = System.nanoTime();

    return (endTime - startTime) / 1000000000.0;
}

    public static void main(String[] args) {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}