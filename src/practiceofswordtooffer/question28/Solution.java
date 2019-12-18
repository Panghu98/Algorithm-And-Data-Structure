package practiceofswordtooffer.question28;

public class Solution  {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public boolean jude(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            //左子树的右节点和右子树的左节点进行对比 ，右子树左节点和左子树右节点进行对比
            return jude(node1.left, node2.right) && jude(node1.right, node2.left);
        }
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        return pRoot==null || jude(pRoot.left, pRoot.right);
    }

}
