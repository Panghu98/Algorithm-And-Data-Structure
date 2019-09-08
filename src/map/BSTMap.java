package map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node,K key,V value){
        //遍历的截止条件
        if (node == null){
            size++;
            return new Node(key,value);
        }
        //向左移动
        if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        //向右移动
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        //找到相等的位置
        }else{
            node.value = value;
        }
        return node;

    }

    //返回以node为根节点的二分搜索树中,key所在的节点
    private Node getNode(Node node,K key) {
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }else if (key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else {
            return node;
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key, value);
    }

    private Node remove(Node node,K key){
        if (node == null){
            return null;
        }

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        // key.compareTo(node.key) == 0
        else {
            //待删除左节点为空
            if (node.left == null){

            }
        }
        return node;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root,key);
        return node==null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
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
