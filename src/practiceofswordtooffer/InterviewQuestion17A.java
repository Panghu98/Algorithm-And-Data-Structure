package practiceofswordtooffer;

/**
 * 如不考虑溢出的问题
 * @author dengg
 */
public class InterviewQuestion17A {

    static void printToMaxOfDigits(int n){

        long max = 1L;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }

        for (int i = 1; i < max; i++) {
            System.out.print(" "+i);
        }
    }

    public static void main(String[] args) {
        printToMaxOfDigits(3);
    }

}
