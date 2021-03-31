package leetcode;


import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 19:05 2021/3/25
 * @Modified By:
 */
public class Leetcode82 {

     public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    private Set<Integer> set = new HashSet<>();

    public ListNode deleteDuplicates(ListNode head) {

        if (head.next == null) {
            return null;
        }

        int value = head.val;


        if (set.contains(value)) {
            head.next = deleteDuplicates(head.next.next);
            return head.next;
        }else {
            set.add(value);
            head.next = deleteDuplicates(head.next);
            return head;
        }


    }

    @Test
    public void test() {
        ListNode node = new ListNode(1,new ListNode
                (1,new ListNode
                        (1,new ListNode
                                (2,new ListNode
                                        (3,new ListNode(2))))));
        ListNode listNode = deleteDuplicates(node);
        System.out.println(listNode.val);
    }

}
