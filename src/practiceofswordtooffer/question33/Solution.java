package practiceofswordtooffer.question33;

/**
 * @author dengg
 */
public class Solution {

    /**
     *
     *  判断一个数组是不是二叉搜索树的结果
     *
     * @param sequence  数组
     * @param start 数组的开始
     * @param end 数组的结束点
     * @return
     */
    public boolean verifySequenceOfBST(int[] sequence,int start,int end) {
        if (sequence == null || end -start <= 0 ) {
            return false;
        }

        //截止位置,此时判定为二叉树
        if (end - start == 1) {
            return true;
        }

        //根节点
        int root = sequence[end-1];

        //在二叉搜索树种左子树节点的值小于更节点的值
        int i = start;
        for (; i < end-1; i++) {
            if (sequence[i] > root) {
                //此时i保存的是左子树最右边的节点+1
                break;
            }
        }

        //在二叉树搜索树中右子树节点的值大于根节点的值
        int j = i;
        for (; j < end-1; j++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        //完整遍历后j保存的是end-1

        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = verifySequenceOfBST(sequence,start,i);
        }

        //判断右子树是不是二叉搜索树
        boolean right = true;
        if (i > 0) {
            right = verifySequenceOfBST(sequence,i,j);
        }

        //返回 子树是否为二叉搜索树的与结果
        return left&&right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5,7,8,9,11,10,8};
        System.err.println(solution.verifySequenceOfBST(arr,0,arr.length));
    }

}
