package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: Created in 22:22 2020/4/5
 * @Modified By:
 */
public class LeetCode_17_12 {

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

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
        // 开始中序遍历
        inorder(root,head);
        return head.right;
    }

    private TreeNode inorder(TreeNode root,TreeNode prev){
        if (root != null){
            prev = inorder(root.left,prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right,prev);
        }
        return prev;
    }


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(7);
        TreeNode head = convertBiNode(treeNode);
        System.out.println();

    }


}
