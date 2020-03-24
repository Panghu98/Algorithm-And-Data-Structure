package leetcode_tencent;

import org.junit.Test;

import java.util.List;

/**
 * @author: panghu
 * @Description:
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: Created in 20:29 2020/3/23
 * @Modified By:
 */
public class Solution2 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          // 参数验证
        if (l1 == null && l2 == null) {
            return null;
        }

        // 头结点，用于连接，后面会删除
        ListNode head = new ListNode(-1);
        ListNode headCopy = head;

        // 进位标记
        boolean isCarry = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (isCarry) {
                ++sum;
                isCarry = false;
            }
            if (sum >= 10) {
                sum = sum - 10;
                isCarry = true;
            }

            headCopy.next = new ListNode(sum);
            headCopy = headCopy.next;
            // 向下移动
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val;
            if (isCarry) {
                sum++;
                isCarry = false;
            }

            if (sum == 10) {
                isCarry = true;
                sum = sum - 10;
            }

            headCopy.next = new ListNode(sum);
            headCopy = headCopy.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val;
            if (isCarry) {
                sum++;
                isCarry = false;
            }

            if (sum == 10) {
                isCarry = true;
                sum = sum - 10;
            }

            headCopy.next = new ListNode(sum);
            headCopy = headCopy.next;

            l2 = l2.next;
        }

        if (isCarry) {
            headCopy.next = new ListNode(1);
        }

        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(2);

        ListNode result = addTwoNumbers(l1,l2);
        System.out.println(result.val);
    }

}
