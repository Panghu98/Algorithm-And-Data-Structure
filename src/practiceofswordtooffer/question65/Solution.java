package practiceofswordtooffer.question65;

import org.junit.Test;

public class Solution {

    public int add(int num1,int num2) {
        //carry进位运算判定
        int sum,carry;
        do {
            //对于不进位的加法运算直接使用异或就行
            sum = num1 ^ num2;
            //进行进位判定
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);

        return num1;
    }

    @Test
    public void test() {
        System.out.println(add(5,17));
    }

}
