package list;

import queue.Queue;

/**
 * @author panghu
 * @title: LinkedListQueue
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-8 下午5:25
 */
public class LinkedListQueue<E> implements Queue<E> {


    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    //从head端删除元素,从tail端插入元素
    /*----------------------------------不直接使用LinkedLIst中的方法进行出队和入队操作----------------------------
                                       降低了复杂度   从O(n) 降为了 O(1)----------*/
    //队首负责出队  队尾负责入队


    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++ ;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        //移除首元素
        Node retNode = head;
        head = head.next;

        //释放空间  利用虚拟机自动回收内存
        retNode.next =null;
        if (head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
