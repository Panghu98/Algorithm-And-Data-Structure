package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 11:42 2021/3/26
 * @Modified By:
 */
public class Leetcode83 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head ;
        }

        ListNode dummyNode = new ListNode(0,head);

        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }

            head = head.next;

        }

        return dummyNode.next;

    }

    @Test
    public void test() {
        ListNode node = new ListNode(1,new ListNode
                (1,new ListNode
                        (1,new ListNode
                                (2,new ListNode
                                        (3,new ListNode(2))))));
        ListNode listNode = deleteDuplicates(node);
        System.out.println(listNode.val);
    }
}
