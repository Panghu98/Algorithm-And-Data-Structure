package search;

/**
 * @author panghu
 * @title: BinarySearchTree
 * @projectName algorithm-data-structure
 * @date 19-7-28 下午9:58
 */
public class BST<E extends Comparable<E>> {

    //二分搜索树内部的节点
    private class Node{
        E data;
        Node left,right;

        public Node(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //二分搜索树的大小
    private int size;

    //根元素
    private Node root;

    public BST() {
        size = 0;
        root = null;
    }

    /**
     * 获取二分搜索树的大小
     * @return 二分搜索树的大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断树是否为空
     * @return true:树为空  false:树不为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 通过递归寻找到合适的位置
     * @param root 节点
     * @param data 数据
     * @return 参数中的node
     */
    private Node add(Node root, E data){

        //根节点为空  直接在根节点进行添加
        if (root == null){
            size ++;
            return new Node(data);
        }

        //与根节点进行比较 调用递归直至放到正确的位置
        if (data.compareTo(root.data) < 0){
            root.left = add(root.left,data);
        }else {
            root.right = add(root.right,data);
        }

        return root;

    }

    public void add(E data) {
        root = add(root, data);
    }

    /**
     * 获取最小值
     * @return 最小值
     */
    public E getMin(){
        if (isEmpty()){
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }
        return getMin(root).data;
    }

    /**
     * 通过递归获取最左边的节点,也就是值最小的节点
     * @param node 节点
     * @return 最左边的节点
     */
    private Node getMin(Node node){
        if (node.left == null){
            return node;
        }
        return getMin(node);
    }


    /**
     * 获取最大值
     * @return 二叉搜索树中的最大值
     */
    public E getMax(){
        if (isEmpty()){
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }
        return getMax(root).data;
    }

    /**
     * 通过递归获取最右边的节点,也就是值最大的节点
     * @param node 节点
     * @return 最右边的节点
     */
    private Node getMax(Node node){
        if (node.right == null){
            return node;
        }
        return getMax(node);
    }

    /**
     * 删除最小值
     * @return 删除的最小值
     */
    public E removeMin(){
        E minData = getMin();
        root = removeMin(root);
        return minData;
    }

    /**
     * 删除掉以node为根的二分搜索树中最小的节点
     * @param node 传入节点
     * @return 返回删除后新的二分搜索树的根
     */
    private Node removeMin(Node node){
        //递归的终止条件:找到了最小的节点
        if (node.left == null){
            //node.right为空也不影响
            Node rightNode = node.right;
            node.right = null;
            size--;
            //返回这一步,就将node.right的节点变成了父亲节点
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大值
     * @return 删除的最大值
     */
    public E removeMax(){
        E maxData = getMax();
        root = removeMax(root);
        return maxData;
    }

    /**
     * 删除掉以node为根的二分搜索树中最大的节点
     * @param node 传入节点
     * @return 返回删除后新的二分搜索树的根
     */
    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

}
