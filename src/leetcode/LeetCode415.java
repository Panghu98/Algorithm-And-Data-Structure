package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:09 2020/3/22
 * @Modified By:
 */
public class LeetCode415 {

    private static final char START = '0';

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean carry = false;
        // 不要遗忘了最后一位进位
        for (int i = 0; i < Math.min(chars1.length,chars2.length) ; i++) {
            char char1 = chars1[i];
            char char2 = chars2[i];
            int resultOfSum = (char1 - START + char2 - START);
            // 判断进位
            if (carry) {
                resultOfSum++;
            }
            // 重新置位
            carry = false;
            if (resultOfSum > 10) {
                resultOfSum = resultOfSum - 10;
                carry = true;
            }

            result.append(resultOfSum);
        }



        if (chars1.length < chars2.length) {
            for (int j = chars1.length; j < chars2.length; j++) {
                if (carry) {
                    int data = (chars2[j] + 1);
                    carry = false;
                    if (data == 10) {
                        carry = true;
                        result.append(0);
                    }else {
                        result.append(chars2[j] - START);
                    }
                }else {
                    result.append(chars2[j] - START);
                }
            }
        }

        if (chars1.length > chars2.length) {
            for (int j = chars2.length; j < chars1.length; j++) {
                if (carry) {
                    chars1[j] = (char) (chars1[j] + 1);
                    carry = false;
                    if (chars1[j] == 10) {
                        carry = true;
                        result.append(0);
                    }else {
                        result.append(chars1[j] - START);
                    }
                }else {
                    result.append(chars1[j] - START);
                }
            }
        }

        if (carry) {
            result.append(1);
        }


        return result.toString();
    }

    @Test
    public void test() {
        System.out.println( addStrings("123456", "87654599"));
    }


}
