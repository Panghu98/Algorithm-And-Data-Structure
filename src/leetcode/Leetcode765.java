package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:05 2021/2/14
 * @Modified By:
 */
public class Leetcode765 {

    public int minSwapsCouples(int[] nums) {
        int length = nums.length;
        int N = length/2;
        UnionFind unionFind = new UnionFind(N);
        // 一对情侣代表的是一个节点 ，通过 除以2的方式判断是不是一个节点

        // N对需要交换的情侣，需要交换N - 1次

        // 交换之后连通分量个数 - 交换值之前的连通分量个数 = 最少的交换次数
        // 例如 有一个size为 3个的连通分量个一个 size为
        for (int i = 0; i < length; i += 2) {
            unionFind.union(nums[i] /2,nums[i + 1] /2 );
        }

        return N - unionFind.getCount();
    }

    static class UnionFind {
        int[] parent ;
        int[] size;

        // 连通分量总数
        int count;

        public UnionFind(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }

            size = new int[count];
            Arrays.fill(size,1);

        }

        private int getCount() {
            return count;
        }

        private int getParent(int current) {
            while (parent[current] != current) {
                // 存储，加快遍历
                parent[current] = parent[parent[current]];
                current = parent[current];
            }

            return current;
        }

        private void union(int x,int y) {
            if (getParent(x) == getParent(y)) {
                return;
            }

            int parentX = getParent(x);
            int parentY = getParent(y);

            if (size[parentX] < size[parentY]) {
                size[parentX] += size[parentY];
                parent[parentY] = parentX;
            }else {
                size[parentY] += size[parentX];
                parent[parentX] = parentY;
            }

            count--;

        }
    }

    @Test
    public void test() {
        System.out.println(minSwapsCouples(new int[]{0,2,4,6,7,1,3,5}));
    }

}
