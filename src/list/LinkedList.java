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

    //虚拟头结点不计入总长度
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
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
    /*-------------------------------------　　　　增加元素　　　　----------------------------------------------*/

    //在链表中的index(0-based)位置添加一个新的元素 --- 不是一个常用的操作
    public void add(int index,E e){{
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add filed. Illegal index ");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //将prev这个节点移动到index这个位置   ---  使用了虚拟的头节点
            prev = prev.next;
            }

        Node node = new Node(e);
        //注意插入的顺序必须是这样  否则会造成prev.next的引用操作丢失
        node.next = prev.next;
        prev.next = node;

        size++;

        }

    }

    //在链表的头部添加新的元素e
    public void addFirst(E e){
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    /*-------------------------------------　　　　查看元素　　　　----------------------------------------------*/

    //获取链表中第index(0-based) 个位置的元素  --- 不常用 用作练习
    public E get(int index){
        if (index < 0 || index >= size){
            throw  new IllegalArgumentException("Get failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表中的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast(){
        return get(size-1);
    }

    //查找链表中是否包含元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    /*-------------------------------------　　　　更改元素　　　　----------------------------------------------*/

    //修改链表的第index(0-based)个未知的元素为e  --  练习使用
    public void set(int index,E e){
        if (index < 0 || index <= size){
            throw new IllegalArgumentException("Set failed. Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            cur.next = cur;
        }
        cur.e = e;
    }



    /*-------------------------------------　　　　删除元素　　　　----------------------------------------------*/

    //从链表中删除index(0-based)未知的元素 返回删除的元素 --- 并不是一个常用的操作
    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    //从链表中删除指定元素
    public void removeElement(E e){
        Node prev = dummyHead;
        //找到对应的位置
        while (prev.next != null){
            if (prev.next.e == e){
                break;
            }
            //移动节点
            prev = prev.next;
        }

        if (prev.next != null){
            //进行删除操作实际上就是跳过一个节点
            Node delNode  = prev.next;
            prev.next = delNode.next;
            //让细虚拟机释放内存
            delNode.next = null;
        }
    }

    //从链表中删除第一个元素,返回删除元素
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("NULL");

        return res.toString();
    }


}
