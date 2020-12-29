package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:05 2020/12/29
 * @Modified By:
 */
public class Leetcode654 {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {



        if (nums == null || nums.length == 0) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;


        TreeNode root = new TreeNode();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                root = new TreeNode(max);
                maxIndex = i;
            }
        }

        int numsLeft = 0;
        int numsRight = nums.length - 1;

        root.left = constructMaximumBinaryTree(getArr(nums,numsLeft,maxIndex-1));
        root.right = constructMaximumBinaryTree(getArr(nums,maxIndex+1,numsRight));

        return root;
    }

    /**
     *
     * @param nums 原数组
     * @param start 开始的位置 （包含）
     * @param end 结束的位置 （包含）
     * @return
     */
    private int[] getArr(int[] nums,int start,int end) {

        if (nums == null) {
            return null;
        }

        if (start > nums.length || end > nums.length || end < start) {
            return null;
        }

        int[] arr = new int[end-start+1];

        int arrIndex = 0;

        // 获取新的数组
        for (int i = 0; i < nums.length; i++) {
            if (i >= start && i <= end) {
                arr[arrIndex++] = nums[i];
            }
        }

        return arr;
    }

}
