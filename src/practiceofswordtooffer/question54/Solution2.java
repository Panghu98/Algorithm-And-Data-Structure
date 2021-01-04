package practiceofswordtooffer.question54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:50 2021/1/3
 * @Modified By:
 */
public class Solution2 {

    class TreeNode {
        int val ;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void tree2List(TreeNode root,List<TreeNode> list) {
        if (root == null) {
            return;
        }
        tree2List(root.left, list);
        list.add(root);
        tree2List(root.right, list);

    }

    public int kthLargest(TreeNode root, int k) {
        List<TreeNode> list =new ArrayList<>();
        // 这个list是从打到小
        tree2List(root,list);

        int size = list.size();
        // 数组下标
        return list.get(size-k).val;
    }

}
