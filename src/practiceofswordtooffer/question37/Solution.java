package practiceofswordtooffer.question37;

import sun.reflect.generics.tree.Tree;

/**
 * @author dengg
 */
public class Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private final static String NULL_NODE = "#";



    public String serialize(TreeNode root) {

        StringBuilder str = new StringBuilder();
        traversalTreeNode(root,str);
        //转换为字符串
        return str.deleteCharAt(str.length()-1).toString();
    }

    private void traversalTreeNode(TreeNode node,StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(NULL_NODE+",");
        }else {
            //不为空添加其值，并遍历其左右子节点
            stringBuilder.append(node.val).append(",");
            traversalTreeNode(node.left,stringBuilder);
            traversalTreeNode(node.right,stringBuilder);
        }

    }


    public TreeNode deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        return deserialize(str.split(","), 0);
    }


    private TreeNode deserialize(String[] arr,int index){
        TreeNode treeNode = null;
        if (index < arr.length) {
            if (!arr[index].equals(NULL_NODE)) {
                treeNode = new TreeNode(Integer.valueOf(arr[index]));
                treeNode.left = deserialize(arr, index*2+1);
                treeNode.right = deserialize(arr,index*2+2);
            }
        }
        return treeNode; }

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {

        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        /**
         *         1
         *       /  \
         *      2    3
         *     / \  / \
         *    4  5  6   7
         *   / \
         *  8   9
         */

        String result = solution.serialize(n1);
        System.out.println(result);
        System.out.println();

        TreeNode root = solution.deserialize(result) ;
        print(root);

    }

    private static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.printf("%-3d", root.val);
            print(root.right);
        }
    }

}
