package array;

/**
 * 如果removeLast和resize出现在同一个便捷的话就会出现复杂度震荡的情况
 * 其解决方案是Lazy  当size==capacity/4时.才将capacity减半
 * 自定义的数组  size指的是数组有效元素的个数
 * @author panghu
 * @title: Array
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-2 下午5:16
 */

// equals和==的区别  前者是数值  后者是引用,内存地址的比较

public class Array<E> {

    //数组
    private E[] data;
    //数组元素的有效个数
    private int size;

    /**
     * 构造函数 传入数组的容量  构造Array
     * @param capacity  数组容量
     */
    public Array(int capacity){

        //不支持一下语法
        //data = new E[capacity];

        data = (E[]) new Object[capacity];
        size = 0;

    }

    /**
     * 无参构造函数,默认数组的容量为10
     */
    public Array() {
        this(10);
    }

    // 获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //获取数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

     //向所有元素后添加一个新的元素
    public void addLast(E e){
        add(size,e);
    }

    //向所有元素之前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }

    //向指定位置index插入一个新的元素e
    public void add(int index,E e){

        //这里的size指的是当前元素的位置
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Require index >= 0 and index <= size");
        }

        if (size == data.length) {
            resize(2*data.length);
        }



        for (int i= size-1 ; i >= index; i--){

            data[i+1] = data[i];

        }
        data[index] = e;
        //记得size++
        size ++;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }

    //获取某一个位置的元素
    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    //获取最后一个未知的元素
    public E getLast(){
        //不直接返回data[size-1] 下面的这种方式能够调用到get方法中的检测机制
        return get(size-1);
    }

    //获取第一个位置的元素
    public E getFirst(){
         return get(0);
    }

    //修改index索引未知的元素e
    public void set(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Set failed.Index is illegal");
        }
        data[index] = e;
    }



    //查看数组中是否包含元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            return data[i].equals(e);
        }
        return true;
    }

    //查看数组中元素e所在的索引,如果不存在e,则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素,返回删除的元素
    //这里不用在意data[size-1]这个元素,因为数组只使用到它存储的元素
    public E remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed.Require index >= 0 and index <= size");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }

        size--;
        //去除引用  让JVM自动回收空间,这句话 不是必需的  loitering objects
        data[size] = null;


        //修改为数组长度的1/4时进行缩容操作
        if (size == data.length/4 && data.length/2 != 0){
            //data.length不能为1
            resize(data.length/2);
        }
        return ret;

    }

    //从数组中删除第一个元素,返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从数组中删除最后一个元素,返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    //从数组中删除元素e 只删除第一个e
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array : size = %d,capacity = %d\n",size,data.length));
        stringBuilder.append('[');
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i!=size-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}
