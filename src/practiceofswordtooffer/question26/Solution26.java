package practiceofswordtooffer.question26;

/**
 * @author dengg
 * @date
 */
public class Solution26 {

    public class TreeNode {
        int val = 0;
        TreeNode right = null;
        TreeNode left = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasSubTree(TreeNode root1,TreeNode root2) {

        if (root2 == null || root1 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val != root2.val) {
            result = doesTree1HasTree2(root1,root2);
        }

        if (!result) {
            result = doesTree1HasTree2(root1.left, root2) || doesTree1HasTree2(root1.right,root2);
        }

        return result;

    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        // 如果第一个树为空直接返回false
        if (root1 == null) {
            return false;
        }

        //空树是任何树的子树
        if (root2 == null) {
            return true;
        }

        // 寻找左节点或者右子节点
        if (root1.val != root2.val) {
            return doesTree1HasTree2(root1.left,root2.left) || doesTree1HasTree2(root1.right,root2.right);
        }

        return doesTree1HasTree2(root1.left,root2.left) && doesTree1HasTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {

    }

}
