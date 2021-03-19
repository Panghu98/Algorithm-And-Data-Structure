package leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 12:39 2021/3/12
 * @Modified By:
 */
public class Leetcode311 {

    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);

        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }

            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

}
