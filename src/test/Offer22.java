package test;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:24 2020/3/4
 * @Modified By:
 */
public class Offer22 {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    /**
     *使用快慢指针可以避免第二次遍历
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int counter = 0;
        ListNode fastIndex = head;
        ListNode slowNode = head;
        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            counter++;
            if (counter >= k) {
                slowNode = slowNode.next;
            }
        }


        return slowNode;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        for (int i = 6; i >= 2; i--) {
            ListNode headNextNode = head.next;
            ListNode next = new ListNode(i);;
            head.next = next;
            next.next = headNextNode;
        }
        System.err.println(getKthFromEnd(head,3).val);
    }
}
