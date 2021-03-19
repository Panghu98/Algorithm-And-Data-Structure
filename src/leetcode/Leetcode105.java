package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:00 2021/3/19
 * @Modified By:
 */
public class Leetcode105 {

      public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;++i) {
            //用preorder[0]去中序数组中查找对应的元素
            if(preorder[0]==inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left = buildTree(pre_left,in_left);
                root.right = buildTree(pre_right,in_right);
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
          if (preorder == null || preorder.length == 0) {
              return null;
          }

          int start = preorder[0];
        TreeNode root = new TreeNode(start);
        for (int i = 0; i < inorder.length; i++) {

            if (inorder[i] == start) {

                // copyOfRange 左边 include 右边 exclude
                int[] inorderLeft = Arrays.copyOfRange(inorder,0,i);
                int[] inorderRight = Arrays.copyOfRange(inorder,i+1,inorder.length);

                // 注意观察 0 是root ,i 的位置root(0)  + left.length
                int[] preOrderLeft = Arrays.copyOfRange(preorder,1,i+1);
                int[] preorderRight = Arrays.copyOfRange(preorder,i+1,preorder.length);

                root.left = buildTree2(preOrderLeft,inorderLeft);
                root.right = buildTree2(preorderRight,inorderRight);

                break;
            }

        }

        return root;
    }

    @Test
    public void test() {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree2(preOrder, inOrder);
        System.out.println(treeNode);
    }

}
