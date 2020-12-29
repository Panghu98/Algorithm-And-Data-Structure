package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:26 2020/12/29
 * @Modified By:
 */
public class LeetCode1379 {


    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null) {
            return null;
        }

        if (original == target){
            return cloned;
        }


        TreeNode res = getTargetCopy(original.left,cloned.left,target);
        if (res != null){
            return res;
        }

        res = getTargetCopy(original.right,cloned.right,target);
        if (res != null){
            return res;
        }

        return null;
    }

}
