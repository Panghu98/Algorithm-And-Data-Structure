package leetcode;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:58 2020/4/4
 * @Modified By:
 */
public class LeetCode07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {

        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[0]);


        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preOrder,1,i + 1),
                        Arrays.copyOfRange(inOrder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preOrder,i + 1,preOrder.length),
                        Arrays.copyOfRange(inOrder,i + 1,preOrder.length));
            }
        }

        return root;
    }
}
