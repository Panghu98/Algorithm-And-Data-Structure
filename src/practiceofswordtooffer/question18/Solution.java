package practiceofswordtooffer.question18;

public class Solution {

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 删除指定节点
     * @param pHead  头结点
     * @param deleteNode 待删除的节点
     * @return
     */
    public ListNode deleteSpecifyNode(ListNode pHead,ListNode deleteNode)
    {
        if (pHead == null) {
            throw new IllegalArgumentException();
        }
        if (pHead == deleteNode) {
            //释放内存
            pHead = null;
            return null;
        }


        ListNode nextNode = pHead.next;
        //寻找待删除的节点
        while (nextNode != deleteNode) {
            nextNode = nextNode.next;
        }

        deleteNextNode(nextNode);
        return pHead;
    }

    /**
     *
     *  node.next是要删除的下一个节点
     */
    void deleteNextNode(ListNode node) {
        //如果要删除的节点的下一个节点为空，也就是要删除的节点为为节点的
        if (node.next.next == null) {
            node.next = null;
        }else {
            ListNode deleteNode = node.next;
            node.next = deleteNode.next;
            //释放内存
            deleteNode = null;
        }
    }

}
