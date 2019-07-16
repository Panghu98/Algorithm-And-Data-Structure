package leetcode;

/**
 * @author panghu
 * @title: Solution70A
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-15 下午9:09
 */
public class Solution70A {

    static int climbStairs(int n){

        if ( n==0){

            return 0;

        }

        if (n ==1){

            return 1;

        }

        return climbStairs(n-1)+climbStairs(n-2);

    }

    public static void main(String[] args) {
        for (int i = 5; i < 41; i+= 5) {
            long start = System.nanoTime();

            climbStairs(i);
            long end = System.nanoTime();

            System.out.println("当n="+i+"算法总耗时"+(end-start)+"  ns");
        }
    }

}
