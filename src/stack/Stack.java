package stack;

/**
 * @author panghu
 * @title: Stack
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-5 下午5:18
 */
public interface Stack<E> {

    //获取栈的大小
    int getSize();
    //查看栈是否为空
    boolean isEmpty();
    //入栈
    void push(E e);
    //出栈
    E pop();
    //查看栈顶的元素但是不进行出栈操作
    E peek();

}
