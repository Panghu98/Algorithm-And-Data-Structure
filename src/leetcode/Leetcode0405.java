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
     *  -：如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/solution/he-fa-er-cha-sou-suo-shu-by-leetcode-sol-y1xm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
