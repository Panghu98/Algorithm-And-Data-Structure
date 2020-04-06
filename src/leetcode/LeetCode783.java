package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:58 2020/4/6
 * @Modified By:
 */
public class LeetCode783 {

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

        int minDiff = Integer.MAX_VALUE;
        int before ;


    public int minDiffInBST(TreeNode root) {
        before = root.val;
        getMinDiff(root);
        return minDiff;
    }

    /**
     * 中序遍历
     * @param root 当前节点
     * @return
     */
    private void getMinDiff(TreeNode root) {
        if (root == null) {
            return;
        }

        getMinDiff(root.left);
        int result = Math.abs(root.val - before);
        if (minDiff > result && result != 0) {
            minDiff = result;
        }
        before = root.val;
        getMinDiff(root.right);
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(90);
        treeNode.left = new TreeNode(69);
        treeNode.left.left = new TreeNode(49);
        treeNode.left.right = new TreeNode(89);
        treeNode.left.left.right = new TreeNode(52);
        int result = minDiffInBST(treeNode);
        System.out.println(result);

    }
}
