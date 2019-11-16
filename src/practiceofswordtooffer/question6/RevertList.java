package practiceofswordtooffer.question6;

import java.util.Stack;

public class RevertList {

    static class Node {
        private int key;
        private Node next;

        public Node() {
        }

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private static void revertPrint(Node head){
        if (head == null){
            return;
        }
        revertPrintRecursive(head);
    }

    private static void revertPrintRecursive(Node head) {
        if (head.next != null){
            revertPrintRecursive(head.next);
        }
        System.out.print(head.key + " ");
    }

    public static void revertPrint2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.key);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static Node generateList(int n){
        Node head = new Node(-1);
        Node temp,tail;
        tail = head;
        for (int i = n-1; i >= 0; i--) {
            temp = new Node(i);
            //使用尾插法 ，将头结点指向下一个节点
            temp.next = tail.next;
            tail.next = temp;
            tail = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = generateList(10);
        revertPrint2(head);
    }
}