package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * @Date: Created in 20:57 2020/4/3
 * @Modified By:
 */
public class LeetCode938 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public int rangeSumBST(TreeNode root, int left, int right) {
           int sum = 0;
           sum = getSum(root,left,right);
           return sum;
    }

    private int getSum(TreeNode root,int left,int right) {
         int sum = 0; 
          
         if (root == null) {
             return 0;
         }
        int result = verify(left, right, root);
        if (result == 0) {
            sum += root.val;
            sum += getSum(root.right, left, right);
            sum += getSum(root.left, left, right);
        }else if (result  == -1) {
            sum += getSum(root.right, left, right);
        }else {
            sum += getSum(root.left, left, right);
        }

        return sum;
    }

    private int verify(int left,int right,TreeNode root) {
        if (root.val > right) {
            return 1;
        }else if (root.val < left) {
            return -1;
        }else {
            return 0;
        }

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root,7,15));
    }

}
