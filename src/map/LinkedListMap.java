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
    public void add(Object key, Object value) {

    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null:node.value;
    }

    @Override
    public void set(Object key, Object newValue) {

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
