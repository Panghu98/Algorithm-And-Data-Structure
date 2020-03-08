package practiceofswordtooffer.question10;

public class FibonacciBottomToTop {

    /**
     * 从上到下的计算方法,也可以利用线性规划,但是会生成大数组
     * @param number  参数,需要计算到第几项
     * @return 斐波那契数的第n项
     */
    private static long fibonacci(int number) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }
        long fibonacci0 = 0;
        long fibonacci1 = 1;
        long result = 0;
        for (int i = 2; i <= number; i++) {
            result = fibonacci0 + fibonacci1;
            fibonacci0 = fibonacci1;
            fibonacci1 = result;
        }
        return result;
    }

    private static long fibonacci2(int number) {
        if (number <= 0) {
            return 0;
        }else if (number == 1) {
            return 1;
        }

        int fibonacci0 = 0;
        int fibonacci1 = 1;

        int result = 0;
        for (int i = number; i <= number; i++) {
            // 向上移动 ？ 何时使用动态规划 -- 树结构
            result = fibonacci0 + fibonacci1;
            fibonacci0 = fibonacci1;
            fibonacci1 = result;
        }

        return result;
    }

        public static void main(String[] args) {
        long result =  fibonacci(10);
        System.err.println(result);
    }
}
