package find;

public interface UF {

    int getSize();

    /**
     * 查询索引为p,q的两个节点是否联通
     * @param p 索引p
     * @param q 索引q
     * @return
     */
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}