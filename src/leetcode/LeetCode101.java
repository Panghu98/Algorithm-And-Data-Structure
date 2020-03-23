package leetcode;

import org.junit.Test;
import practiceofswordtooffer.question34.Solution;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 17:53 2020/3/23
 * @Modified By:
 */
public class LeetCode101 {



      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helpJudge(root.left,root.right);
    }

    public boolean helpJudge(TreeNode left,TreeNode right) {
          if (left == null && right == null) {
              return true;
          }else if (right != null && left != null) {
              return right.val == left.val&&helpJudge(left.left, right.right)
                      &&helpJudge(left.right, right.left);
          }

          // 一个为空一个不为空的情况
          return false;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);


        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);

        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;
        System.out.println(isSymmetric(t1));
    }

}
