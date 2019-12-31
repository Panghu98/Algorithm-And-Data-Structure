package practiceofswordtooffer.question55;

/**
 * @author dengg
 */
public class Solution {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    // 最大深度
    private int maxDepth = 0;

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //重置深度
        maxDepth = 0;

        treeDepthPreOrderReverse(root,0);
        return maxDepth;
    }

    /**
     * 树深度遍历--前序遍历
     */
    private void treeDepthPreOrderReverse(TreeNode node,int depth) {
        if (node != null) {
            depth ++;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            treeDepthPreOrderReverse(node.left, depth);
            treeDepthPreOrderReverse(node.right, depth);
        }

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        Solution solution = new Solution();
        System.out.println(solution.TreeDepth(root));
        System.out.println(solution.TreeDepth(root.left.right));
    }

}
