package practiceofswordtooffer.question7;

import javax.xml.soap.Node;
import java.lang.reflect.Array;
import java.util.Arrays;

public class RebuildBinaryTree {

    public RebuildBinaryTree() {
    }

    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode() {
        }
    }

    public TreeNode rebuildBinaryTree(int[] pre,int[] in) {

        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        //确定根节点
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                //左子树，使用copyOfRange函数，左闭合右开
                /**
                 *  copyOfRange参数说明
                 *  @param original the array from which a range is to be copied
                 *  @param from the initial index of the range to be copied, inclusive
                 *  @param to the final index of the range to be copied, exclusive.
                 */
                root.left = rebuildBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in, 0, i));

                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = rebuildBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    private static void printBinaryTreePreOrder(TreeNode node) {
        if (node == null){
            return;
        }
        System.out.print(node.value+" ");
        printBinaryTreePreOrder(node.left);
        printBinaryTreePreOrder(node.right);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new RebuildBinaryTree().rebuildBinaryTree(pre,in);
        printBinaryTreePreOrder(root);
    }

}
