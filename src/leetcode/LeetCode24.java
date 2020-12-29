package leetcode;

import java.util.Scanner;

/**
 * @author: panghu
 * @Description:
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * @Date: Created in 11:17 2020/12/27
 * @Modified By:
 */
public class LeetCode24 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;

        switchNode(pre, head);

        return pre.next;
    }

    public static void switchNode(ListNode pre,ListNode current) {


        if (current == null) {
            return;
        }

        ListNode next = current.next;
        if (next == null) {
            return;
        }

        ListNode nextNext = next.next;

        // 前继节点
        pre.next = next;

        next.next = current;
        current.next = nextNext;

        switchNode(current,nextNext);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2,new ListNode(3,new ListNode(4)));
        ListNode node1 = swapPairs(node);

        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

}

