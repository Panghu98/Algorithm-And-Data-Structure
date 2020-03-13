package practiceofswordtooffer.question55;

public class Solution2 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int depth(TreeNode root){
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        if(left == -1) {
            return -1;
        }
        int right = depth(root.right);
        //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        if(right == -1) {
            return -1;
        }
        if(left - right <(-1) || left - right > 1) {
            return -1;
        } else {
            //这一步很关键，计算深度
            return 1+(Math.max(left, right));
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

}
