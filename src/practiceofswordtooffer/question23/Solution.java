package practiceofswordtooffer.question23;


public class
Solution {

    static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode entryNodeOfLoop(ListNode pNode){

        if (pNode == null) {
            throw new NullPointerException("The headOf List can`t be null");
        }

        ListNode fastPointer = pNode.next;
        ListNode slowPointer = pNode;

        //走到结尾
        while (fastPointer.next != null) {

            if (fastPointer == slowPointer) {
                return fastPointer;
            //移动指针,判断,再移动指针
            }else {
                fastPointer = fastPointer.next;
                if (fastPointer != slowPointer) {
                    fastPointer = fastPointer.next;
                }
            }

            //移动慢指针
            if (fastPointer != slowPointer) {
                slowPointer  = slowPointer.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode cycleNode = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6  = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = cycleNode;
        cycleNode.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = cycleNode;

        Solution solution = new Solution();
        ListNode listNode = solution.entryNodeOfLoop(head);
        System.err.println(listNode.val);
    }
}