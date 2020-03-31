package leetcode;

import leetcode_tencent.Solution2;
import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 23:10 2020/3/31
 * @Modified By:
 */
public class Solution61 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 1;
        ListNode copyHead = head;
        while (copyHead.next != null) {
            length++;
            copyHead  = copyHead.next;
        }

        //用于记录需要旋转的次数
        int counter = k % length;
        // 刚好旋转一周，节点数量为一很成立
        if (counter == 0) {
            return head;
        }

        // 用于形成循环链表
        copyHead.next = head;

        // 需要将next置位null的节点，也就是新的头结点的上一个节点
        ListNode pre = new ListNode(0);

        // 真正需要旋转的次数
        counter = length -counter;
        while (counter != 0) {
            if (counter == 1) {
                pre = head;
            }

            head = head.next;
            counter--;
        }
        pre.next = null;
        return head;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = rotateRight(node,1);
        System.out.println(result.val);
    }

}
