package practiceofswordtooffer.question54;

/**
 * @author dengg
 */
public class Solution {


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    //计数器，记录是第几个大的节点
    int counter = 0;

    public TreeNode KthNode(TreeNode pRoot, int k){

        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            counter ++;

            if (counter == k) {
                return pRoot;
            }

            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }

        }
        return null;

    }
}
