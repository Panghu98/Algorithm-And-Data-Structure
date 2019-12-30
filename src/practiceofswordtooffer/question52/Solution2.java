package practiceofswordtooffer.question52;

import org.junit.Test;

public class Solution2 {

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

        //链表1和链表2的长度
        int length1 = 0,length2 = 0;

        ListNode p1 = pHead1,p2 = pHead2;

        while (pHead1.next != null) {
            length1++;
            pHead1 = pHead1.next;
        }

        while (pHead2.next != null) {
            length2++;
            pHead2 = pHead2.next;
        }

        //数值差 小于0 则链表2 更长，同理；
        int numericalDifference = length1 - length2;
        int absoluteDifference = Math.abs(numericalDifference);

        //长链表先行
        while (absoluteDifference > 0) {
            if (numericalDifference < 0) {
                if (p2.next != null) {
                    p2 = p2.next;
                }
            }else {
                if (p1.next != null) {
                    p1 = p1.next;
                }
            }
            absoluteDifference--;
        }

        //同时遍历寻找相同的节点
        while (p1.next != null && p2.next != null) {
            if (p1.next != p2.next) {
                p1 = p1.next;
                p2 = p2.next;
            }else {
                return p1.next;
            }
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
