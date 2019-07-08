package queue;

import array.Array;

/**
 * @author panghu
 * @title: ArrarQueue
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-7 下午12:58
 */
public class ArrayQueue<E> implements Queue<E> {

    public Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
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

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        //removeFirst的返回值是移除元素
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: ");
        stringBuilder.append("Front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i!=array.getSize()-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] Tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);


            if (i%3 == 2){
                queue.dequeue();
            }


            System.out.println(queue);
        }
    }
}
