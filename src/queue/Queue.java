package queue;

/**
 * @author panghu
 * @title: Queue
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-6 下午8:42
 */
public interface Queue<E> {

    //获取队列的长度
    int getSize();
    //查看队列是否为空
    boolean isEmpty();
    //入栈
    void enqueue(E e);
    //出栈
    E dequeue();
    //查看队首的元素
    E getFront();

}
