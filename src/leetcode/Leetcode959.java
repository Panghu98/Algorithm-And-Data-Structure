package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:43 2021/1/25
 * @Modified By:
 */
public class Leetcode959 {

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;

        UnionFind unionFind = new UnionFind(size);

        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            // row.length和N相等
            for (int j = 0; j < row.length; j++) {
                // 二维网格转换为一维表格，index 表示将单元格拆分成 4 个小三角形以后，编号为 0 的小三角形的在并查集中的下标
                int index = 4 * (i * N + j);

                char ch = row[j];
                // 方格里面的合并
                if ('/' == ch) {
                    unionFind.union(index,index + 3);
                    unionFind.union(index + 1,index + 2);
                }else if ('\\' == ch) {
                    unionFind.union(index,index + 1);
                    unionFind.union(index + 3,index + 2);
                }else {
                    // 将小方格完全和合并
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }

                // 单元格间合并
                // 向右合并：1（当前）、3（右一列）
                if (j + 1 < N) {
                    unionFind.union(index + 1, 4 * ( + 1) + 3);
                }
                // 向下合并：2（当前）、0（下一行）
                if (i + 1 < N) {
                    unionFind.union(index + 2, 4 * ((i + 1) * N + j));
                }

            }
        }

        return unionFind.getSize();
    }

    private class UnionFind {

        private int[] parent;

        private int size;

        private int getSize() {
            return size;
        }

        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                // 根节点的指向
                parent[i] = i;
            }
        }

        public int find(int index) {
            while (index != parent[index]) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }

        public void union(int x,int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            size--;

        }
    }

}
