package leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:49 2021/3/10
 * @Modified By:
 */
public class Leetcode224 {

    public int calculate2(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);

        int ret = 0;
        int sign = 1;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                // 用于计算多位数
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;
        int i = 0;
        int ret = 0;
        while (i < n) {
            char item = s.charAt(i);
            if (s.charAt(i) == ' ') {
                i++;
            }else if (item == '-') {
                sign = -ops.peek();
                ++i;
            }else if (item == '+') {
                sign = ops.peek();
                ++i;
            }else if (item == '(') {
                ops.push(sign);
                ++i;
            }else if (item == ')') {
                ops.pop();
                ++i;
            }else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    ++i;
                }

                ret +=sign * num;
            }

        }

        return ret;
    }

}
