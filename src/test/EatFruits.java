package test;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:06 2020/6/5
 * @Modified By:
 */
public class EatFruits {

    /**
     * 可放入的水果数量
     */
    static Semaphore n = new Semaphore(10);

    /**
     * 盘中苹果的数量
     */
    static Semaphore apple = new Semaphore(0);

    /**
     * 盘中橘子的数量
     */
    static Semaphore orange = new Semaphore(0);

    /**
     * 用于模拟生成放苹果(1)还是橘子(0)
     */
    static Random fruitSelector = new Random();

    private static CategoryEnum fruitSelect() {
        return fruitSelector.nextInt(2)==1?CategoryEnum.APPLE:CategoryEnum.ORANGE;
    }

    public static void main(String[] args) {
        Runnable father = () -> {
            while (true) {
                // 注意代码的顺序，先要判断能不能放入
                try {
                    // 可放入的数量减一
                    n.acquire();
                    // 模拟放入
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //选择水果种类
                CategoryEnum category = fruitSelect();
                if (CategoryEnum.ORANGE == category) {
                    orange.release();
                    System.out.println("父亲放入了一个橘子，现在盘中的橘子数量为: " + orange.availablePermits());
                }else {
                    apple.release();
                    System.out.println("父亲放入了一个苹果，现在盘中的苹果数量为: " + apple.availablePermits());
                }
            }
        };

        Runnable son = () -> {
            while (true) {
                try {
                    // 吃掉一个橘子
                    orange.acquire();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("儿子吃掉了一个橘子，盘子里还剩：" + orange.availablePermits());
                    n.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 女儿
        Runnable daughter = () -> {
            while (true) {
                try {
                    // 吃掉一个橘子
                    apple.acquire();
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("女子吃掉了一个苹果，盘子里还剩：" + apple.availablePermits());
                    n.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(father,"father").start();
        new Thread(son,"son").start();
//        new Thread(daughter,"daughter").start();

    }

}


enum  CategoryEnum{
    ORANGE(0),
    APPLE(1);
    int value;

    CategoryEnum(int value) {
        this.value = value;
    }
}