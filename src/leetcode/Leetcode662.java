package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:34 2021/1/6
 * @Modified By:
 */
public class Leetcode662 {

      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    /**
     * 基本思想，转化成一颗满二叉树
     * @param
     * @return
     */



    /**
     *
     * @param list 所有节点
     * @param temp 父
     * @param tmp 子
     */
    public void inorderTraverse(List<TreeNode> list,List<TreeNode> temp,List<TreeNode> tmp) {

        if (temp.isEmpty()) {
            return;
        }

        list.addAll(temp);

        while ( !temp.isEmpty()) {
            // 出队
            TreeNode item = temp.remove(0);

            TreeNode left = item.left;
            if (left != null) {
                tmp.add(left);
            }

            TreeNode right = item.right;
            if (right != null) {
                tmp.add(right);
            }
        }

        temp.addAll(tmp);
        tmp.clear();

        inorderTraverse(list, temp,tmp);
    }

    @Test
    public void test() {


    }

    public static void main(String[] args) {
        Leetcode662 leetcode662 = new Leetcode662();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7,
                new TreeNode(2,new TreeNode(9),null),
                new TreeNode(10,new TreeNode(1),new TreeNode(4)));

        root.right = new TreeNode(8,
                new TreeNode(1),
                new TreeNode(3,null,new TreeNode(5)));

        List<TreeNode> tmp = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);

        leetcode662.inorderTraverse(list,temp,tmp);

        list.forEach(item -> System.out.println(item.val));
    }

}
