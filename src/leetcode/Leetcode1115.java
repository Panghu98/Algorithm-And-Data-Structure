package leetcode;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper.print;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:25 2021/3/20
 * @Modified By:
 */
public class Leetcode1115 {

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    private void printBar(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            bar.acquire();
            print("bar");
            foo.release();
        }
    }

    private void printFoo(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            foo.acquire();
            print("foo");
            bar.release();
        }
    }

    @Test
    public void test() throws InterruptedException {

        int n =20;


        new Thread(() -> {
            try {
                printFoo(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                printBar(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void print(String word) {
        System.out.print(word);
    }

}
