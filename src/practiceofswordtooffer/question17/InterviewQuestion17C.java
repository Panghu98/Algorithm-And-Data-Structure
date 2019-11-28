package practiceofswordtooffer.question17;

/**
 * @author dengg
 *  递归实现方式
 */
public class InterviewQuestion17C {

    public static class PrintOneToMaxNthDigits2 {

        //输出函数
        void printNumber(StringBuffer sb){
            boolean flag = false;

            for(int i = 0; i < sb.length(); i++){
                if(!flag && sb.charAt(i) != '0'){
                    flag = true;
                }
                if(flag){
                    System.out.print(sb.charAt(i));
                }
            }
            if(flag) {
                System.out.print(" ");
            }
        }

        void print1ToMaxOfNDigitsRecursively(StringBuffer sb, int n, int index){
            if(index == n){
                printNumber(sb);
                return ;
            }

            for(int i = 0; i < 10; i++){
                sb.setCharAt(index, (char)(i+'0'));
                print1ToMaxOfNDigitsRecursively(sb, n, index+1);
            }
        }

        //打印从1到n位的最大数
        void Print1ToMaxOfNDigits(int n){
            if(n <= 0) {
                return ;
            }
            //初始化数字（用StringBuffer表示）
            StringBuffer sb = new StringBuffer(n);
            for(int i = 0; i < n; i++){
                sb.append('0');
            }
            print1ToMaxOfNDigitsRecursively(sb, n, 0);
        }

        public static void main(String[] args) {
            PrintOneToMaxNthDigits2 test = new PrintOneToMaxNthDigits2();
            test.Print1ToMaxOfNDigits(3);
        }

    }
}
