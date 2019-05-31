package test;

import java.util.Random;

/**
 * @author panghu
 * @title: Reflect
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-27 上午8:42
 */
public class Reflect {

    public static void main(String[] args) {
       testRandom();
    }


    /**
     * 设置种子之后，相同的种子生成的随机数一致
     */
    public static void testRandom(){
        System.out.println("Random不设置种子：");
        for (int i = 0; i < 5; i++) {
            Random random = new Random(1);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(100) + ", ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Random设置种子：");
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            random.setSeed(1);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(100) + ", ");
            }
            System.out.println();
        }
    }



}
