package practiceofswordtooffer.question52;

import org.junit.Test;

import java.util.Stack;

/**
 * @author dengg
 */
public class Solution {

     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

         if (pHead1 == null || pHead2 == null) {
             return null;
         }

         // 辅助栈1，存储链表1
        Stack<ListNode> stack1 = new Stack<>();
        // 辅助栈2，存储链表2
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1.next != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2.next != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        if (stack1.size() != 0 && stack2.size() != 0) {
            ListNode node = null;
            // 赋值操作
            while (stack1.peek() == stack2.peek()) {
                node = stack1.pop();
                stack2.pop();
            }
            //帮助GC
            stack1 = null;
            stack2 = null;
            return node;
        }

        return null;
    }

    @Test
    public void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;

        System.out.println(FindFirstCommonNode(n1, n4).val);
    }


}
