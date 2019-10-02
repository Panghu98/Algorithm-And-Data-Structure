package find;

public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {

        id = new int[size];

        // 初始化, 每一个id[i]指向自己, 没有合并的元素
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }

    }

    // 查找元素p所对应的集合编号
    // O(1)复杂度
    private int find(int p) {
        if(p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        return id[p];
    }


    @Override
    public int getSize() {
        return id.length;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        // 合并过程需要遍历一遍所有元素, 将两个元素的所属集合编号合并
        //注意是合并集合，是将集合的值进行改变
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

    }
}
