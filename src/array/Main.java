package array;

import stack.ArrayStack;

/**
 * @author panghu
 * @title: Main
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-2 下午4:42
 */
public class Main {

    public static void main(String[] args) {


        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }

}
