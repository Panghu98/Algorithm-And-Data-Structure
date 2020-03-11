package practiceofswordtooffer.question36;

import test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:16 2020/3/10
 * @Modified By:
 */
public class Solution_Copy {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode convert(TreeNode root) {
        //参数验证
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>(10);
        convert(list,root);
        return convertListToNode(list);
    }

    public void convert(List<TreeNode> list,TreeNode root) {

        if (root == null) {
            return;
        }

        convert(list,root.left);
        list.add(root);
        convert(list,root.right);

    }

    public TreeNode convertListToNode(List<TreeNode> list) {
        for (int i = 0; i < list.size()-1; i++) {
            TreeNode preNode = list.get(i);
            TreeNode nextNode = list.get(i+1);
            preNode.right = nextNode;
            nextNode.left = preNode;
        }
        return list.get(0);
    }

}
