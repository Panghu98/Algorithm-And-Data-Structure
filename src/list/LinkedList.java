package list;

/**
 * @author panghu
 * @title: LinkedList
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-8 上午11:04
 */
public class LinkedList<E> {

    private class Node{

        public E e;
        public Node next;

        public Node(E e, Node next) {
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

    private Node dummyHead;;
    private int size;

    public LinkedList() {
        dummyHead = null;
        size = 0;
    }
    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    //查看链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表的头部添加新的元素e
    public void addFirst(E e){
        add(0, e);
    }

    //在链表中的index(0-based)位置添加一个新的元素 --- 不是一个常用的操作
    public void add(int index,E e){{
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add filed. Illegal index ");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //将prev这个节点移动到index这个位置   ---  使用了虚拟的头节点
            prev = prev.next;

            Node node = new Node(e);
            //注意插入的顺序必须是这样  否则会造成prev.next的引用操作丢失
            node.next = prev.next;
            prev.next = node;

            size++;

            }

        }

    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }



}
