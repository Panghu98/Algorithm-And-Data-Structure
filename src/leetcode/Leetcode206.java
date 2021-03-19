package leetcode;

import jdk.management.resource.NotifyingMeter;
import org.junit.Test;

import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 16:08 2021/3/19
 * @Modified By:
 */
public class Leetcode206 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {

        // 遍历到最后一位元素
        if (head.next == null) {
            return head;
        }

        // 最后一位数
        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;

        ListNode current = head;

        while (current != null)     {
            ListNode next = current.next;
            current.next = pre;

            // 保存前继节点
            pre = current;
            // 向下滑动
            current = next;
        }

        return pre;

    }

    @Test
    public void test() {
//        ListNode node = reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        ListNode node = new ListNode(1,new ListNode(2));
        node = reverseList2(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
