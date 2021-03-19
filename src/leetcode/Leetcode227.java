package leetcode;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:49 2021/3/11
 * @Modified By:
 */
public class Leetcode227 {

    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }


            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n -1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num );
                        break;
                    default:
                        stack.push(stack.pop()/ num );
                        break;

                }
                num = 0;
                preSign = s.charAt(i);
            }

        }

        return stack.stream().mapToInt(Integer::intValue).sum();


    }

    @Test
    public void test() {
        System.out.println(calculate("3/2"));
    }

}
