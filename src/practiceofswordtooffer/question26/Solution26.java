package practiceofswordtooffer.question26;

import org.junit.Test;

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
        // 如果没有找到头结点
        if (root1.val != root2.val) {
            result = doesTree1HasTree2(root1.left,root2.left) || doesTree1HasTree2(root1.right,root2.right);
        }else {
            //找到头结点
            result = doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
        }

        return result;

    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        // 如果第一个树为空直接返回false
        if (root1 == null && root2 != null) {
            return false;
        }

        //空树是任何树的子树
        if (root2 == null) {
            return true;
        }

        // 寻找左节点或者右子节点
        if (root1.val != root2.val) {
            return doesTree1HasTree2(root1.left,root2) || doesTree1HasTree2(root1.right,root2);
        }

        return doesTree1HasTree2(root1.left,root2.left) && doesTree1HasTree2(root1.right,root2.right);
    }

    @Test
    public void test() {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(7);

        System.err.println(hasSubTree(root1,root2));

    }

}
