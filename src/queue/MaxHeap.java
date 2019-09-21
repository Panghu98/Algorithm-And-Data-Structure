package queue;


/**
 * @author panghu
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
            shiftDown(i);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private void shiftDown(int k) {
        //完全二叉树的特性,向左对齐
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            // 在此轮循环中,data[k]和data[j]交换位置

            //j + 1 < data.getSize()用于判断存在右孩子,如果右孩子存在且比左孩子大的话就取右孩子
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j++;
            }

            //如果父节点比(孩子节点中的较大节点)相比数值更大,退出循环
            if (data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }

            //交换子节点和父节点数值
            data.swap(k,j);
            //继续循环,将子节点作为当前节点
            k = j;
        }
    }

    /**
     * 获取堆张总最大的元素 如果堆不为空则是数组所以为0对应的元素
     *
     * @return 最大值
     */
    public E findMax(){
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 获取最大堆的大小
     *
     * @return 最大堆的大小
     */
    public int getSize() {
        return data.getSize();
    }

    /**
     * 获取最大堆是否为空
     *
     * @return 空:true;非空:false.
     */
    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    /**
     * 获取指定索引的父节点索引
     *
     * @param index 直接的索引
     * @return 返回的父节点索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 does`nt have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取指定父节点索引的左孩子的索引
     *
     * @param index 父节点索引
     * @return 左孩子的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取指定父节点索引的右孩子的索引
     *
     * @param index 父节点索引
     * @return 右孩子的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素
     *
     * @param e 需要添加的元素值
     */
    public void add(E e) {
        data.addLast(e);
        //data.getSize() - 1指的是新添加元素的的数组下标
        shiftUp(data.getSize() - 1);
    }

    /**
     * 取出堆中的最大值
     * 查看并移除
     *
     * @return 堆中的最大值
     */
    public E extractMax() {
        //获取到最大值
        E ret = findMax();

        //与最后一个元素进行交换并移除最后一个元素,也就是移除最大值
        //如果这里是使用根节点的子节点进行替换的话可能会破坏二叉树的结构
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        //此时根节点并不是数值最大的节点进行下移操作
        shiftDown(0);

        return ret;
    }

    /**
     * 取出堆中的最元素,并且替换为元素e
     *
     * @param e 需要替换成的元素
     * @return 最大值
     */
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        shiftDown(0);
        return ret;
    }

    public int size(){
        return data.getSize();
    }
}
