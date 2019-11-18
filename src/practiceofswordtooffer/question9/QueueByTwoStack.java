package practiceofswordtooffer.question9;

import stack.Stack;

public class QueueByTwoStack<T> {


    //内部栈1,用于操作
    private Stack<T> stack1;

    //用于数据存储
    private Stack<T> stack2;

    private T deleteHead() {
         return stack2.pop();
    }

    private void appendTail(T data) {
        /**
         *   1.将stack2中的元素放入stack1
         *    stack1     stack2
         *   |_c_|      |___|
         *   |_b_|      |___|
         *   |_a_|      |___|
         */
        while ( !stack2.isEmpty() ){
            stack1.push(stack2.pop());
        }

        /**
         *   2.然后在stack2中放入需要添加的元素
         *    stack1     stack2
         *   |_c_|      |___|
         *   |_b_|      |___|
         *   |_a_|      |_d_|
         */
        stack1.push(data);

        /**
         *   3.将stack1放入stack2
         *    stack1     stack2
         *   |___|      |_a_|
         *   |___|      |_b_|
         *   |___|      |_c_|
         *   |___|      |_d_|
         */
        while ( !stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
}
