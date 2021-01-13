package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 11:58 2021/1/13
 * @Modified By:
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        invertTreeRecursion(root);
        return root;
    }

    private void invertTreeRecursion(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return;
        }
        // 后序遍历

        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);

        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));

        invertTree(root);

    }

}
