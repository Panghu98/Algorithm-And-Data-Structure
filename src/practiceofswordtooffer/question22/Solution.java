package practiceofswordtooffer.question22;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findKthToTail(ListNode head,int k) {
        //验证参数
        if (k <= 0) {
            throw new IllegalArgumentException("index can`t be negative");
        }

        //验证链表
        if (head == null) {
            return null;
        }

        ListNode pNode = head,pTail = null;
        int counter = 0;
        while (pNode.next != null) {
            pNode = pNode.next;
            counter ++ ;

            if (counter == k -1) {
                pTail = head;
            }

            if (counter > k -1) {
                pTail = pTail.next;
            }
        }

        //节点小于k
        return pTail;
    }

    public static void main(String[] args) {

        //使用尾插法 进行数据插入
        ListNode head =  new ListNode(0);
        ListNode tail = head;

        for (int i = 1; i < 2; i++) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
        }

        // 0 1 2 3 4 5

        tail.next = null;

        ListNode node1 = findKthToTail(head,-1);
        if (node1 != null) {
            System.err.println(node1.val);
        }
    }

    /**
     * 尾插方
     * @param n
     * @return
     */
    public static ListNode generateListByTailInsert(int n){
        ListNode head = new ListNode(-1);
        ListNode temp,tail;
        tail = head;
        for (int i = 0; i < n; i++) {
            temp = new ListNode(i);
            //使用尾插法 ，将头结点指向下一个节点
            tail.next = temp;
            tail = temp;
        }
        tail.next = null;
        //返回的结果应该为 -1,0,....n
        return head;
    }

    /**
     * 头插法
     * @param n
     * @return
     */
    public static ListNode generateListByHeadInsert(int n) {
        ListNode head = new ListNode(-1);
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(i);
            //移动头指针
            node.next = head.next;
            head.next = node;
        }
        //返回的结果应该为 -1,n,n-1... 0
        return head;
    }

}
