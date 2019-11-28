package practiceofswordtooffer.question18;

import java.util.List;

public class Solution2 {


    public void deleteDuplicationNode(Solution.ListNode headNode) {
        if (headNode == null) {
            throw new IllegalArgumentException();
        }

        Solution.ListNode tempNode = headNode;
        while (tempNode.next != null) {
            //不重复，向后移动
            if (tempNode.next.value != tempNode.value) {
                tempNode = tempNode.next;
            }else {
                Solution.ListNode tempNode2 = tempNode;
                int value = tempNode2.value;
                while (tempNode2.value == value) {
                    tempNode2 = tempNode2.next;
                }
                //复制接节点删除法
                tempNode.next = tempNode2.next;
                tempNode.value = tempNode2.value;
                tempNode2 = null;
            }
        }
    }

    public void deleteCurrentNode(Solution.ListNode node) {
        //如果要删除的节点的下一个节点为空，也就是要删除的节点尾节点的
        if (node.next == null) {
            node = null;
        }else {
            //复制节点
            node.next = node.next.next;
            node.value = node.next.value;
            node.next = null;
        }
    }

}
