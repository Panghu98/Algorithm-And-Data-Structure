package labuladong;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:20 2020/12/26
 * @Modified By:
 */
public class Fibonacci {

    public static int fibonacci(int n,int[] men) {

        if (n == 2 || n == 1) {
            men[1] = men[2] = 1;
            return 1;
        }else {
            men[n] = fibonacci(n-1, men) + fibonacci(n -2, men);
        }

        return men[n];
    }

    public static int fibonacci2(int n) {
        int[] mem = new int[n + 1];

        mem[1] = mem[2] = 1;

        if (n == 1 || n ==2) {
            return 1;
        }

        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i -2];
        }

        return mem[n];

    }

    public static void main(String[] args) {

        int n = 20;

        int[] men = new int[n+1];
        System.err.println(fibonacci2(n));
        System.out.println(fibonacci(n,men));
    }
}
