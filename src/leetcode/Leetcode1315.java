package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 14:54 2021/1/2
 * @Modified By:
 */
public class Leetcode1315 {

     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, -1) + sumEvenGrandparent(root.right, -1) + sumEvenGrandparent(root.left, -1);
    }

    public int sumEvenGrandparent(TreeNode root, int even) {
        if(root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if(root.left != null) {
            left = sumEvenGrandparent(root.left.left, root.val) + sumEvenGrandparent(root.left.right, root.val);
        }
        if(root.right != null) {
            right = sumEvenGrandparent(root.right.left, root.val) + sumEvenGrandparent(root.right.right, root.val);
        }
        return even % 2 == 0 ? left + right + root.val : left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7,
                new TreeNode(2,new TreeNode(9),null),
                new TreeNode(7,new TreeNode(1),new TreeNode(4)));

        root.right = new TreeNode(8,
                new TreeNode(1),
                new TreeNode(3,null,new TreeNode(5)));


        System.err.println(new Leetcode1315().sumEvenGrandparent(root));
    }

}
