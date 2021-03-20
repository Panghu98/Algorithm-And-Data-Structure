package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 15:37 2021/3/20
 * @Modified By:
 */
public class Leetcode155 {

    class MinStack {

        Stack<Integer> stack = new Stack<>();

        Stack<Integer> minStack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            }else {
                Integer peek = minStack.peek();
                if (peek <= val) {
                    minStack.push(peek);
                }else {
                    minStack.push(val);
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
