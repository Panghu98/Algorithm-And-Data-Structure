package practiceofswordtooffer.question32;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dengg
 */
public class Solution {

     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {


        Deque<TreeNode> deque = new LinkedList<>();
        //用于存储返回的项目
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        //将头结点添加到队列的首部
        deque.add(root);


        while(!deque.isEmpty()){
            TreeNode node = deque.getFirst();
            //将双向队列的首部出队
            deque.pollFirst();
            res.add(node.val);

            //分别将左子节点和右子节点放入队尾
            if(node.left != null) {
                deque.addLast(node.left);
            }

            if(node.right != null) {
                deque.addLast(node.right);
            }
        }

        return res;

    }



}
