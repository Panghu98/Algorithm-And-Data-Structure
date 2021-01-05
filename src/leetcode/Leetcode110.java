package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:36 2020/12/31
 * @Modified By:
 */
public class Leetcode110 {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public boolean isBalanced(TreeNode root) {
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }else {
            // 理解一下这个加一的操作 + 每一层向下递归都需要加一层深度
            return Math.max(depth(root.left),depth(root.right)) + 1;
        }
    }


}
