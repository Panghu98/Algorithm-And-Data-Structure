package practiceofswordtooffer.question27;

public class Solution27 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void getMirrorTree(TreeNode root) {
        // 如果是null的话直接退出
        if (root == null) {
            return;
        }

        //结束标志
        if (root.left == null && root.right == null) {
            return;
        }

        //交换节点
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        //交换子节点
        if (root.left != null) {
            getMirrorTree(root.left);
        }

        if (root.right != null) {
            getMirrorTree(root.right);
        }
    }

}
