package practiceofswordtooffer.question36;

import java.util.ArrayList;

/**
 * @author dengg
 */
public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        ArrayList<TreeNode> arrayList = new ArrayList<>();
        convert(pRootOfTree,arrayList);
        return convert(arrayList);

    }


    //中序遍历，在list中按遍历顺序保存
    public void convert(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        if(pRootOfTree.left != null){
            convert(pRootOfTree.left, list);
        }

        list.add(pRootOfTree);

        if(pRootOfTree.right != null){
            convert(pRootOfTree.right, list);
        }
    }


    //遍历list，修改指针--之前只添加了键值，没有维护节点之间的关系
    public TreeNode convert(ArrayList<TreeNode> list){
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }


}
