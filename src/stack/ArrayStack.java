package stack;

import array.Array;

/**
 * @author panghu
 * @title: ArrayStack
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-5 下午5:21
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    //这里是将数组的其实位置作为栈底
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        //可以直接利用Array的removeLast方法中的返回值
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append("Stack: ");
        stringBuilder.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize()-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();

    }
}
