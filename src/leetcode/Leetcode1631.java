package leetcode;

import array.Array;
import org.junit.Test;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:35 2021/1/29
 * @Modified By:
 */
public class Leetcode1631 {

    public int minimumEffortPath(int[][] heights) {
        int depth = heights.length;
        int weight = heights[0].length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < weight; j++) {

                // 当前点的索引
                int index = i * weight + j;

                if (i > 0) {
                    edges.add(new int[]
                            {index - weight,
                                    index,
                                    Math.abs(heights[i][j] - heights[i-1][j])});

                }

                if (j > 0) {
                    edges.add(new int[]
                            {index - 1,
                                    index,
                                    Math.abs(heights[i][j] - heights[i][j-1])});

                }

            }
        }

        // 根据颠簸度排序
        edges.sort(Comparator.comparingInt(item -> item[2]));

        UnionFind unionFind = new UnionFind(depth * weight);
        int ans = 0;
        for (int i = 0; i < edges.size(); i++) {
            int[] item = edges.get(i);
            int referPoint = item[0];
            int currentPoint = item[1];
            int diff = item[2];
            System.out.println(referPoint + "-" + currentPoint + "-" + diff);
            unionFind.union(referPoint,currentPoint);

            if (unionFind.connected(0,depth*weight -1)) {
                ans = diff;
                break;
            }
        }

        return ans;

    }



    class  UnionFind {
        // 连通量
        int size;
        // 根节点
        int[] parents;
        // 权重 - 根节点下的树的节点数
        int[] weights;

        public UnionFind(int size) {
            this.size = size;
            parents = new int[size];
            weights = new int[size];
            // 初始化根节点
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            Arrays.fill(weights,1);
        }

        /**
         * 获取指定节点的根节点
         * @param x
         * @return
         */
        private int find(int x) {
            while (parents[x] != x) {
                // 进行路径压缩
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        /**
         * 两个节点直接是否连通
         * @return
         */
        private boolean connected(int x,int y) {
            int xParent = find(x);
            int yParent = find(y);

            return xParent == yParent;
        }

        /**
         * 合并两个连通分量
         * @param x
         * @param y
         */
        private void union(int x,int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent) {
                return;
            }

            // 保证x是大数，都接到x下面
            if (weights[xParent] < weights[yParent]) {
                parents[xParent] = yParent;
                weights[yParent] += weights[xParent];
            }else {
                parents[yParent] = xParent;
                weights[xParent] += weights[yParent];
            }

            // 连通分量减少
            --size;

        }

    }

    @Test
    public void test() {
        minimumEffortPath(new int[][]{
                {4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}
        });
    }
}
