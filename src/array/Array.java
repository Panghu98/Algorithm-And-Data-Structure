package array;

/**
 * @author panghu
 * @title: Array
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-2 下午5:16
 */
public class Array {

    private int[] data;
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
}
