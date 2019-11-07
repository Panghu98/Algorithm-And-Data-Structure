package practiceofswordtooffer.question17;

public class InterviewQuestion17B {

    /**
     * 使用数组对数进行+1操作
     * @param number 传入的数组
     * @return
     */
    private static boolean increment(int[] number){

        //标记是否进位
        boolean isOverFlow = false;

        //标记进位位置
        int carry = 0;

        for (int i = number.length - 1; i >= 0; i--) {

            int sum =  number[i] + carry;
            if (i == number.length-1){
                sum ++;
            }

            if (sum >= 10){
                if (i == 0 ){
                    isOverFlow = true;
                }else {
                    sum = sum -10;
                    carry = 1;
                    number[i] = sum;
                }
            }else {
                number[i]++;
                break;
            }
        }
        return isOverFlow;
    }

    /**
     * 打印数组中的树，如果数组中表示的数字位数小于n,这不答应前面的0
     */
    public static void print(int[] number){
        // 标记  判断是否可以开始打印
        boolean isBeginning = false;
        for (int i = 0; i < number.length; i++) {
            if (!isBeginning && number[i] != 0){
                isBeginning = true;
            }
            if (isBeginning){
                System.out.print(number[i]);
            }
        }
        System.out.print(" ");
    }

    public static void main(String[] args) {
        //使用数组来模拟大数
        int[] number = new int[3];
        while(!increment(number)){
            print(number);
        }
    }
}
