package leetcode_tencent;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @Date: Created in 20:11 2020/3/24
 * @Modified By:
 */
public class Solution104 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getDepth(0,root);

    }

    /**
     * 递归获得深度
     * @param depth 当前深度
     * @param root  当前的节点
     * @return 当前节点的最大深度
     */
    private int getDepth(int depth,TreeNode root) {
          if (root == null) {
              return depth;
          }
          depth++;
          return Math.max(getDepth(depth,root.left),getDepth(depth,root.right));
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(20);
        root.right.right = new TreeNode(20);

        System.out.println(maxDepth(root));
    }

}
