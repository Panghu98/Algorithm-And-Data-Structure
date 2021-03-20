package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 15:58 2021/3/20
 * @Modified By:
 */
public class Leetcode236 {

     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         // 返回父节点或者是到了叶子节点
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

         if (root == null || p == root || q == root) {
             return root;
         }

         TreeNode left = lowestCommonAncestor2(root.left,p,q);
         TreeNode right = lowestCommonAncestor(root.right,p,q);


         if (left == null) {
             return right;
         }

         if (right == null) {
             return left;
         }

         return root;

    }


    @Test
    public void test() {

    }

}
