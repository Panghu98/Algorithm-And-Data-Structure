package array;

/**
 *
 * 自定义的数组  size指的是数组有效元素的个数
 * @author panghu
 * @title: Array
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-2 下午5:16
 */
public class Array {

    //数组
    private int[] data;
    //数组元素的有效个数
    private int size;

    /**
     * 构造函数 传入数组的容量  构造Array
     * @param capacity  数组容量
     */
    public Array(int capacity){

        data = new int[capacity];
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
    public void addLast(int e){
        add(size,e);
    }

    //向所有元素之前添加一个新元素
    public void addFirst(int e){
        add(0,e);
    }

    //向指定位置index插入一个新的元素e
    public void add(int index,int e){
        if (size == data.length){
            throw new IllegalArgumentException("AddLast failed.Array is full");
        }

        //这里的size指的是当前元素的位置
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Require index >= 0 and index <= size");
        }

        for (int i= size-1 ; i >= index; i--){

            data[i+1] = data[i];

        }
        data[index] = e;
        //记得size++
        size ++;
    }

    //获取某一个位置的元素
    public int get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    //修改index索引未知的元素e
    public void set(int index,int e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Set failed.Index is illegal");
        }
        data[index] = e;
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

    //查看数组中是否包含元素e
    public boolean contains(int e){
        for (int i = 0; i < size; i++) {
            return data[i] == e;
        }
        return true;
    }

    //查看数组中元素e所在的索引,如果不存在e,则返回-1
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素,返回删除的元素
    //这里不用在意data[size-1]这个元素,因为数组只使用到它存储的元素
    public int remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed.Require index >= 0 and index <= size");
        }
        int ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }

        size--;
        return ret;

    }

    //从数组中删除第一个元素,返回删除的元素
    public int removeFirst(){
        return remove(0);
    }

    //从数组中删除最后一个元素,返回删除的元素
    public int removeLast(){
        return remove(size-1);
    }

    //从数组中删除元素e 只删除第一个e
    public void removeElement(int e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }






}
