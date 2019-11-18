package practiceofswordtooffer.question10;

public class FibonacciRecursive {

    static long fibonacciRecursive(int number) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
        }
    }

    public static void main(String[] args) {
        long result = fibonacciRecursive(10);
        System.err.println(result);
    }

}
