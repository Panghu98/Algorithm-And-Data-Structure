package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:44 2021/1/13
 * @Modified By:
 */
public class LeetCode538 {

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

    public TreeNode convertBST(TreeNode root) {
        traverseTree(root);
        return root;
    }

    private boolean arrive = Boolean.FALSE;

    private TreeNode pre;

    private void traverseTree(TreeNode node) {

        if (node == null) {
            return;
        }

        traverseTree(node.right);

        if (arrive) {
            node.val = pre.val + node.val;
        }else {
            arrive = Boolean.TRUE;
        }

        pre = node;

        traverseTree(node.left);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,null,new TreeNode(3))),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7,null,new TreeNode(8))));

        convertBST(root);
    }

}
