package map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value){
            this(key, value, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }

    }

    //虚拟头结点
    private Node dummyHead;

    //大小
    private int size;

    /**
     * 获取指定key的Node节点
     * @param key 键名
     * @return 存在返回Node,不存在返回null
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;
        //循环遍历获取节点键名并判断
        while (cur != null){
            if (cur.key == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    

    @Override
    public void add(K key, V value) {
        //尝试获取相同的节点
        Node node = getNode(key);
        //如果不存在节点,则直接添加在头结点之后
        if (node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
//            Node oldDummyHeadNextHead = dummyHead.next;
//            Node dummyHeadNextHead = new Node(key,value);
//            dummyHead.next = dummyHeadNextHead;
//            dummyHeadNextHead.next = oldDummyHeadNextHead;

            //这四步和上面的一步是同样的效果
            //1.获取原头结点的下一个节点node1
            //2.创建新的节点 node2
            //3.将新的节点赋值为头结点的下一个节点
            //4.将node2的下一个节点设置为node1

        }else {
            //覆盖原来的值
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        //获取到正确的节点
        while (prev.next != null){
            if ( prev.next.key.equals(key)){
                break;
            }
            //移动节点到下一个节点
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            //删除节点的核心  也可写作 prev.next = prev.next.next
            prev.next = delNode.next;
            //释放内存
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
