package practiceofswordtooffer.question24;



public class Solution {

    static class ListNode {

        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        //记录当前访问的节点
        ListNode pNode = head;
        ListNode pPre = null;
        //用于记录反转后的头结点
        ListNode pReverseHead = null;
        while (pNode != null) {

            ListNode pNext = pNode.next;

            //不能直接返回 ,否则会断链
            if (pNext == null) {
                pReverseHead = pNode;
            }

            //将当前节点指向之前的节点
            pNode.next = pPre;

            //移动前节点指针
            pPre = pNode;

            //移动指针
            pNode = pNext;
        }

        return pReverseHead;
    }

    public static void main(String[] args) {
        //使用尾插法 进行数据插入
        ListNode head =  new ListNode(0);
        ListNode tail = head;

        for (int i = 1; i < 6; i++) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
        }

        // 0 1 2 3 4 5

        tail.next = null;

        Solution solution = new Solution();
        ListNode node = solution.reverseList(head);
        System.err.println(node.val);
    }
}