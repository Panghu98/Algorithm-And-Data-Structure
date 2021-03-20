package leetcode;

import org.junit.Test;

import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:59 2021/3/20
 * @Modified By:
 */
public class Leetcode234 {

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

    public boolean isPalindrome(ListNode head) {

        ListNode quickPin = head, slowPin = head;
        // 移动指针
        while (quickPin.next != null) {
            quickPin = quickPin.next;
            if (quickPin.next != null) {
                quickPin = quickPin.next;
            }

            slowPin = slowPin.next;
        }

        // 移动完成之后quickPin指向终点，slowPin指向中点
        ListNode reverse = reverse(slowPin);
        while (reverse != null && head != slowPin) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode root) {

        ListNode pre = null;

        // 1 -> 2 -> 3
        while (root != null) {
            // next = 2
            ListNode next = root.next;
            // 1.next = null
            root.next = pre;
            // pre = 2
            pre = root;

            // root = 2
            root = next;
        }

        return pre;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(3,new ListNode(2,new ListNode(1))))));
        System.out.println(isPalindrome(listNode));
    }

}
