package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 17:05 2021/1/4
 * @Modified By:
 */
public class Leetcode112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        // 到达叶子节点，判定是否为路径和
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }


        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }

}
