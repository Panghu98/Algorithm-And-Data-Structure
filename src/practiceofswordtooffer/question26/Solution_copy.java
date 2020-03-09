package practiceofswordtooffer.question26;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:29 2020/3/9
 * @Modified By:
 */
public class Solution_copy{

    public class TreeNode {
        int val = 0;
        TreeNode right = null;
        TreeNode left = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param root1 父树
     * @param root2 子树
     * @return
     */
    public boolean hasSubTree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }

        boolean result = false;

        // 如果没有找到头结点
        if (root1.val != root2.val) {
            result = doHasSunTree(root1.left,root2.left) || doHasSunTree(root1.right,root2.right);
        }else {
            //找到头结点
            result = doHasSunTree(root1.left, root2.left) && doHasSunTree(root1.right, root2.right);
        }

        return result;


    }

    private boolean doHasSunTree(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }

        if (root2 == null) {
            return true;
        }

        boolean result = false;


        // 如果没有找到头结点
        if (root1.val != root2.val) {
            return doHasSunTree(root1.left,root2) || doHasSunTree(root1.right,root2);
        }

        //找到头结点
        return doHasSunTree(root1.left, root2.left) && doHasSunTree(root1.right, root2.right);
    }

    @Test
    public void test() {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(2);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(7);

        System.err.println(hasSubTree(root1,root2));

    }

}