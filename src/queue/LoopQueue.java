package queue;

import java.util.Objects;

/**
 * @author panghu
 * @title: LoopQueue
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-7 下午5:22
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front =0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public void enqueue(E e) {
        //循环队列是否满
        if ((tail+1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    private void resize(int capacity){
        E[] newData= (E[]) new Object[capacity+1];
        for (int i = 0; i < size; i++) {
            //front会发生偏移,所以要加上front的偏移量
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        //在新的数组当中front的起始位置是0
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from a empty queue");
        }
        E ret = data[front];
        //这哟不可以不需要
        data[front] = null;
        //将front进行移动
        front = (front+1) % data.length;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2 != 0 ){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from a empty queue");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue : size = %d,capacity = %d\n",size,getCapacity()));
        stringBuilder.append("Front [");
        for (int i = front; i !=tail; i=(i+1) %data.length) {
            stringBuilder.append(data[i]);
            //这里和上面的resize的遍历方式效果是一样的
            if ((i+1) %data.length != tail){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);


            if (i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }


        }
    }

}
