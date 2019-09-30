package tree;

import java.util.TreeMap;

public class Trie {

    private class Node{

        public boolean isWord;
        //通过next指向下一个节点.是通过线段,而不是节点,头一个节点为空
        public TreeMap<Character,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;


    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie的词的数量
     * @return Trie的大小
     */
    public int getSize() {
        return size;
    }


        /**
     * 向Trie中添加一个新的单词
     * @param word 新的单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //如果后继节点不是指向c,创建一个新的节点
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        //判断是否已经存在,如果已经存在,不再进行size++操作
        if (!cur.isWord){
            //标示一个词的结尾(不一定是叶子节点,因为一个词可能是另外一个词的前缀)
            cur.isWord = true;
            size ++;
        }
    }

    /**
     * 向Trie中添加一个新的单词
     * @param word 新的单词
     */
    public void recursionAdd(String word) {
        add(root, word, 0);
    }

    /**
     * 递归写法调用方法实现递归添加
     *
     * @param node 传入要进行添加的节点
     * @param word 传入要进行添加的单词
     */
    public void add(Node node, String word, int index) {
        // 确定终止条件,这个终止条件在没加index这个参数时,很难确定
        // 此时一个单词已经遍历完成了,如果这个结束节点没有标记为单词,就标记为单词
        if (!node.isWord && index == word.length()) {
            node.isWord = true;
            size++;
        }

        if (word.length() > index) {
            char addLetter = word.charAt(index);
            // 判断trie的下个节点组中是否有查询的字符,如果没有,就添加
            if (node.next.get(addLetter) == null) {
                node.next.put(addLetter, new Node());
            }
            // 基于已经存在的字符进行下个字符的递归查询
            add(node.next.get(addLetter), word, index + 1);
        }
    }

    /**
     * 查询单词word是否在Trie当中
     * @param word 待查询的字符串
     * @return 返回的结果
     */
    public boolean contains(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询单词word中是否在Trie中接口(递归写法)
     *
     * @param word 单词
     * @return 是否存在
     */
    public boolean recursionContains(String word) {
        return contains(root, word, 0);
    }

    /**
     * 查询word中是否在Trie中递归写法
     *
     * @param node 当前节点
     * @param word 单词
     * @param index 字符串所在索引
     * @return  是否存在
     */
    private boolean contains(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        } else {
            return contains(node.next.get(c), word, index + 1);
        }
    }
}