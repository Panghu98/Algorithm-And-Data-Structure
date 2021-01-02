package leetcode;

/**
 * @author: panghu
 * @link https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 * @Date: Created in 16:13 2021/1/2
 * @Modified By:
 */
public class Leetcode0405 {

    /**
     * 搜索二叉树的判定条件
     *  -
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

}
