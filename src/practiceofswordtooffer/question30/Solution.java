package practiceofswordtooffer.question30;


import java.util.Stack;

/**
 * @author dengg
 */
public class Solution {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        }else {
            //存入较小的那个
            int num = minStack.peek();
            minStack.push(Math.min(num,node));
        }
    }

    public void pop() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return Integer.MIN_VALUE;
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return Integer.MIN_VALUE;
    }

}
