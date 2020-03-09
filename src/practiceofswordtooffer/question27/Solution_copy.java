package practiceofswordtooffer.question27;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:36 2020/3/9
 * @Modified By:
 */
public class Solution_copy {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void getMirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }

        //结束标志,其实使用上面的那个结束标志也是可以的
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            getMirrorTree(root.left);
        }

        if (root.right != null) {
            getMirrorTree(root.right);
        }

    }


}