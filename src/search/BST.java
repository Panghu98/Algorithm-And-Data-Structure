package search;

import java.util.Random;
import java.util.Stack;

/**
 * @author panghu
 * @title: BinarySearchTree
 * @projectName algorithm-data-structure
 * @date 19-7-28 下午9:58
 */
public class BST<K,E extends Comparable<E>> {

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
     * 查询二叉搜索树中是否存在该元素
     * @param data 查询的数据
     * @return false-不存在,true-存在
     */
    public boolean contains(E data){
        return contains(root,data);
    }

    private boolean contains(Node node,E data){
        //如果根节点为空时,结束递归
        if (node == null){
            return false;
        }

        //找到相等的值
        if (node.data.compareTo(data) == 0){
            return true;
        }
        //如果寻找的节点值比当前根节点大  向右继续寻找
        else if (node.data.compareTo(data) < 0){
            return contains(node.right,data);
        }
        //如果寻找的节点值比当前根节点小  向左继续寻找
        else {
            return contains(node.left,data);
        }

    }



    /**
     * 增加元素  调用的函数
     * @param data 添加的数据
     */
    public void add(E data) {
        root = add(root, data);
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

    /*
    ---------------------------------------  树的遍历操作  ------------------------------------------------
     */

    /**
     * 对二叉树进行前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历的递归方式,深度优先
     * 当前节点->左孩子->右孩子
     * @param node 传入的节点
     */
    private void preOrder(Node node){
        //遍历到叶子节点时,退出当前的路线
        if (node == null){
            return;
        }

        //1.遍历当前节点
        System.out.print(node.data+"->");

        //2.遍历左孩子
        preOrder(node.left);

        //3.遍历右孩子
        preOrder(node.right);
    }

    /**
     * 前序遍历的非递归实现方式
     */
    public void preOrderNr(){

        //使用栈辅助实现前序遍历
        Stack<Node> stack = new Stack<>();

        /*
        前序遍历的过程就是先访问当前节点,然后再访问左子树,然后再右子树
        使用栈实现的时候,可以先将当前的节点入栈
        当前节点出站的时候,分别将右孩子,左孩子入(栈的特点:先进后出)
         */
        stack.push(root);
        //栈不为空时
        while (!stack.isEmpty()){
            Node node = stack.pop();
            //前序遍历当前的节点
            System.out.print(node.data + "->");

            //先进后出
            if (node.right != null){
                stack.push(node.right);
            }

            if (node.left != null){
                stack.push(node.left);
            }
        }


    }

    /**
     * 对中序遍历进行中序遍历
     */
    public void midOrder(){
        midOrder(root);
    }

    /**
     * 中序遍历的递归方式,深度优先
     * 左孩子->当前节点->右孩子
     * @param node 传入的节点
     */
    private void midOrder(Node node){
        if (node == null){
            return;
        }

        //1.中序遍历左孩子
        midOrder(node.left);

        //2.遍历根节点
        System.out.print(node.data+"->");

        //3.遍历右孩子
        midOrder(node.right);
    }

    /**
     * 中序遍历的非递归实现方式
     */
    public void midOrderNr(){

        //使用栈辅助实现前序遍历
        Stack<Node> stack = new Stack<>();

        //辅助节点
        Node p = root;
        stack.add(p);

        System.err.println();
        //只要存在左孩子,就将左孩子入栈
        while (!stack.isEmpty()){
            if (p != null && p.left != null){
                stack.add(p.left);
                p = p.left;
            }else {
                p = stack.pop();
                System.out.print(p.data+"->");
                if (p != null && p.right != null){
                    //将右孩子入栈
                    stack.add(p.right);
                    p = p.right;
                }else {
                    p = null;
                }
            }
        }
    }

    /**
     * 二叉树的后序遍历
     */
    public void afterOrder(){
        afterOrder(root);
    }

    /**
     * 左孩子->右孩子->父节点
     * @param node 父节点
     */
    private void afterOrder(Node node) {
        if (node == null){
            return;
        }

        afterOrder(node.left);

        afterOrder(node.right);

        System.out.print(node.data+"->");

    }

    /**
     * 后序遍历的非递归实现方式
     */
    public void afterOrderNr(){

       if (root != null){
           Stack<Node> stack = new Stack<>();
           stack.push(root);
           Node p;
           while (!stack.isEmpty()){
               p = stack.peek();
               if (p.left != null && root != p.left && root != p.right){
                   stack.push(p.left);
               }else if (p.right != null && root!= p.right){
                   stack.push(p.right);
               }else {
                   System.err.print(stack.pop().data+"->");
                   root = p;
               }
           }
       }

    }




    public static void main(String[] args) {

        BST tree = new BST();
        Random random = new Random(1);

        for (int i = 0; i < 5; i++) {
            int value = random.nextInt(100);
            System.out.print(value+" ");
            tree.add(value);
        }

        System.out.println();
        tree.afterOrderNr();
        System.out.println();
        tree.afterOrder();

    }

}
