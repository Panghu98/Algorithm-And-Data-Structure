package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 15:41 2020/12/28
 * @Modified By:
 */
public class LeetCode865 {

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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        DepTreeNode depth = depth(root);
        return depth.getNode();

    }

    /**
     * 逻辑保证node不为空
     * @param node
     * @return
     */
    private DepTreeNode depth(TreeNode node) {

        if (node == null) {
            return new DepTreeNode(null,0);
        }

        DepTreeNode L = depth(node.left);
        DepTreeNode R = depth(node.right);


        if (L.depth == R.depth) {
            return new DepTreeNode(node,L.depth);
        }

        return L.depth > R.depth ? new DepTreeNode(L.node,L.depth+1) : new DepTreeNode(R.node,R.depth + 1);



    }

    class DepTreeNode {

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        /**
         * 节点应用
         */
        private TreeNode node;

        /**
         * 深度
         */
        private int depth;

        public DepTreeNode() {
        }

        public DepTreeNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4)));
        root.right = new TreeNode(1,new TreeNode(0),new TreeNode(8));

        LeetCode865 leetCode = new LeetCode865();
        leetCode.subtreeWithAllDeepest(root);
    }

}
