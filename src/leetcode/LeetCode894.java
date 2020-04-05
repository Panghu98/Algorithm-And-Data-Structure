package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:13 2020/4/4
 * @Modified By:
 */
public class LeetCode894 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public List<TreeNode> allPossibleFBT(int N) {
          List<TreeNode> list = new ArrayList<>();

          // 奇数不可能有满二叉树
        if (N % 2 == 0) {
            return list;
        }

        TreeNode root = new TreeNode(0);


        addTreeNode(N,1,list,root);
        return list;
    }

    public void addTreeNode(int maxSize,int currentSize,List<TreeNode> list,TreeNode root) {


        if (maxSize == currentSize) {
            list.add(root);
        }

        addChild(root);
        addTreeNode(maxSize, currentSize+2, list, root.left);
        addTreeNode(maxSize, currentSize+2, list, root.right);

    }


    private void addChild(TreeNode root) {
          root.left = new TreeNode(0);
          root.right = new TreeNode(0);
    }

    @Test
    public void test() {
        List<TreeNode> list = allPossibleFBT(7);
        System.out.println(list);
    }

}
