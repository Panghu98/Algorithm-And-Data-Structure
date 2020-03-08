package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:38 2020/2/27
 * @Modified By:
 */
public class ExecutorServiceTest {

    public void processSequentially(List<Integer> list) {
        for (Integer integer : list) {
            invokeMethod();
        }
    }

    public void processInParallel(Executor executor,List<Integer> list) {
        for (Integer integer : list) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    invokeMethod();
                }
            });
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>(60);
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        ExecutorServiceTest instance = new ExecutorServiceTest();
        long t1 = System.currentTimeMillis();
        instance.processSequentially(list);
        long t2 = System.currentTimeMillis();

        System.out.println("============================");
        System.err.println(t2-t1);
        long t3 = System.currentTimeMillis();
        instance.processInParallel(new ThreadPoolExecutor(100,1000,10
                ,TimeUnit.MINUTES,new LinkedBlockingQueue<>()),list);
        long t4 = System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println("============================");
        System.err.println(t4-t3);

    }

    public void invokeMethod()  {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
