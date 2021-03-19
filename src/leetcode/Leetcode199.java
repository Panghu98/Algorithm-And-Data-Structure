package leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:09 2021/3/19
 * @Modified By:
 */
public class Leetcode199 {

    public class TreeNode {
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


    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        Deque<TreeNode> deque = new LinkedList<>();

        deque.push(root);
        while ( !deque.isEmpty()) {

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();

                if (poll.left != null) {
                    deque.addLast(poll.left);
                }


                if (poll.right != null) {
                    deque.addLast(poll.right);
                }

                if (i == size -1) {
                    // 上层的最后一个
                    list.add(poll.val);
                }

            }

        }

        return list;


    }


    @Test
    public void test() {
//        TreeNode treeNode  = new TreeNode(0);
        TreeNode treeNode = new TreeNode(1, new TreeNode(2,null,new TreeNode(5)),
                new TreeNode(3,new TreeNode(4),null));
        List<Integer> list = rightSideView(treeNode);
        System.out.println(list);
    }

}
