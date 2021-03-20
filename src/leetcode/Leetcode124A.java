package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 15:20 2021/3/20
 * @Modified By:
 */
public class Leetcode124A {

      public class TreeNode {
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

    public int maxPathSum(TreeNode root) {
        help(root);
        return maxValue;
    }

    private int maxValue = Integer.MIN_VALUE;

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(help(root.left),0);
        int right = Math.max(help(root.right),0);

        maxValue = Math.max(maxValue,left + right + root.val);
        // 上一层只能选其中一个
        return root.val + Math.max(left,right);
    }

}
