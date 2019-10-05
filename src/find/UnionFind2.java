package find;

/**
 * @author panghu
 */
public class UnionFind2 implements UF {

    //第二版Union-Find, 使用一个数组构建一棵指向父节点的树

    /**
     * parent[i]表示第i个元素所指向的父节点
     */
    private int[] parent;

    // 构造函数
    public UnionFind2(int size) {

        parent = new int[size];

        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 这个大小指的是节点的大小,而不是元素的数量(其实也是将节点当做是元素)
     *
     * @return 大小
     */
    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程,查找元素p所对应的集合编号(根节点)
     *
     * @param p 元素p
     * @return 根节点
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        //不断去查询自己的父亲接单,知道到达根节点
        // 根节点的特点: parent[p] == p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看元素p和元素q是否属于同一个集合
     *
     * @param p 索引p
     * @param q 索引q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     *  O(h)复杂度, h为树的高度
     */
    @Override
    public void unionElements(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent){
            return;
        }
        parent[pParent] = qParent;
    }
}
