package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:24 2021/3/5
 * @Modified By:
 */
public class Leetcode232 {

    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.addElement(stack1.pop());
        }
        Integer pop = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.addElement(stack2.pop());
        }
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.addElement(stack1.pop());
        }
        Integer peek = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.addElement(stack2.pop());
        }
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }


    @Test
    public void test() {
        Leetcode232 leetcode232 = new Leetcode232();
        leetcode232.push(1);
        leetcode232.push(2);
        System.out.println(leetcode232.peek());
        System.out.println(leetcode232.pop());
        System.out.println(leetcode232.stack1.isEmpty());
    }

}
