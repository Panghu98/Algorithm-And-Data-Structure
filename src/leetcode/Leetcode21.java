package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:25 2021/3/20
 * @Modified By:
 */
public class Leetcode21 {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();

        ListNode pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode next = l1.next;
                l1.next = null;
                head.next = l1;
                head = head.next;
                l1 = next;
            }else {
                ListNode next = l2.next;
                l2.next = null;
                head.next = l2;
                head = head.next;
                l2 = next;
            }
        }

        if (l1  != null) {
            head.next = l1;
        }else {
            head.next = l2;
        }

        return pre.next;

    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

}
