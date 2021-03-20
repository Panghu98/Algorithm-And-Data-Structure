package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 13:02 2021/3/20
 * @Modified By:
 */
public class Leetcode106 {

      class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

          public ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int sizeA = 0;
         int sizeB = 0;
         ListNode hA = headA;
         ListNode hB = headB;
         while (hA != null) {
             hA = hA.next;
             ++sizeA;
         }

         while (hB != null) {
             hB = hB.next;
             ++sizeB;
         }

         int distance = sizeA - sizeB;
         // 先行
         if (distance >= 0) {
             int counter = 0;
             while (headA != null && counter != distance) {
                 ++counter;
                 headA = headA.next;
             }
         }else {
             int counter = 0;
             while (headB != null && counter != distance) {
                 --counter;
                 headB = headB.next;
             }
         }

         while (headA != null && headB != null) {
             if (headA != headB) {
                 headA = headA.next;
                 headB = headB.next;
             }else {
                 return headA;
             }
         }
         return null;
    }

    @Test
    public void test() {
        ListNode headA = new ListNode(9, new ListNode(1, new ListNode(2, new ListNode(4,null))));
        ListNode headB = new ListNode(3, new ListNode(2, new ListNode(4, null)));
        System.out.println(getIntersectionNode(headA,headB).val);
    }

}
