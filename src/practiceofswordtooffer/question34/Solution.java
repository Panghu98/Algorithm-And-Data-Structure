package practiceofswordtooffer.question34;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author dengg
 *
 * 链接：https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 总结：
 *     FindPath(TreeNode root, int target)解决的问题是找到以root为根的树，和为target的路径。
 *     要解决这个问题，需要以下步骤
 *         1.以左孩子为根的树，和为target-root.val的路径（子问题）
 *         2.以右孩子为根的树，和为target-root.val的路径（子问题）
 *         3.遍历1、2两步得到的路径结果，然后将root.val插到路径结果最前面
 *     可以看出这个问题的结果可以由其子问题的结果合并得到，所以可以使用递归来解决。
 *     最后需要注意按照路径长度从大到小排序一下路径，参照归并排序合并有序元素时的思想即可。
 */
public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //根节点为空，则直接路径和,同时也是进行叶子结点判断的依据
        if (root == null) {
            //
            return res;
        }

        //当只有root这一条路径的时候
        if (root.left == null && root.right == null  &&root.val == target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.val);
            res.add(path);
            return res;
        }

        ArrayList<ArrayList<Integer>> leftRes = findPath(root.left,target-root.val);
        ArrayList<ArrayList<Integer>> rightRes = findPath(root.right,target-root.val);

        //添加更节点到路径上
        addValToPath(leftRes,root.val);
        addValToPath(rightRes,root.val);

        // 保证数据长度长的排前面。用类似归并排序合并有序的思想，因为leftRes、rightRes已经有序
        int leftPoint = 0,rightPoint = 0;

        //合并左子树路径集合和右子树路径集合
        while (leftPoint != leftRes.size() && rightPoint != rightRes.size()) {
            if (leftRes.get(leftPoint).size() > rightRes.get(rightPoint).size()) {
                res.add(leftRes.get(leftPoint++));
            } else {
                res.add(rightRes.get(rightPoint++));
            }
        }
        while (leftPoint < leftRes.size()) {
            res.add(leftRes.get(leftPoint++));
        }
        while (rightPoint < rightRes.size()) {
            res.add(rightRes.get(rightPoint++));
        }
        return res;

    }

    /**
     * 将某一个数值添加到路径集合的所有路径的第一位
     * @param res 路径集合
     * @param val 值
     */
    private void addValToPath(ArrayList<ArrayList<Integer>> res, int val) {
        if (res == null) {
            return;
        }
        for (ArrayList<Integer> path : res)
            path.add(0, val);
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(3);
        t1.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        ArrayList<ArrayList<Integer>> res = findPath(t1, 22);
        for (ArrayList<Integer> path : res) {
            System.out.println(path);
        }
    }
}
