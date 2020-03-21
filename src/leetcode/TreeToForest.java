package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:58 2020/3/18
 * @Modified By:
 */
public class TreeToForest {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

      }

    private LinkedList<TreeNode> res = new LinkedList<TreeNode>();
    private HashSet<Integer> deleteSet;

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        deleteSet = new HashSet<>(toDelete.length);
        for (int delete : toDelete) {
            deleteSet.add(delete);
        }
        helper(root, true);
        return res;
    }

    private boolean helper(TreeNode root, boolean isAdd) {
        if (root != null) {
            if (deleteSet.contains(root.val)) {
                if (helper(root.left, true)) {
                    root.left = null;
                }
                if (helper(root.right, true)) {
                    root.right = null;
                }
                return true;
            }
            // 如果编辑为可添加，则添加，使用的其实还是说后序遍历
            if (isAdd) {
                res.add(root);
            }
            // 在删除结点当中才会进行添加和删除操作

            if (helper(root.left, false)) {
                root.left = null;
            }

            if (helper(root.right, false)) {
                root.right = null;
            }
        }
        return false;
    }

    @Test
    public void test() {
          TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.right = new TreeNode(3);
          root.left.left = new TreeNode(4);
          root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        List<TreeNode> list;
          list = delNodes(root,new int[]{3,5,12});
        System.out.println(Arrays.toString(list.toArray()));
    }

}
