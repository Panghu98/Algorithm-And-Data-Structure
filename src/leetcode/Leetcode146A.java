package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 10:05 2021/3/19
 * @Modified By:
 */
public class Leetcode146A {

    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));


    }


}

class LRUCache {

    private int size;

    private  int capacity;

    private ListNode head, tail;

    private HashMap<Integer,ListNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new ListNode();
        this.tail = new ListNode();

        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        ListNode listNode = cache.get(key);
        if (listNode == null) {
            return -1;
        }

        // 当亲
        move2Head(listNode);
        return listNode.value;
    }

    public void put(int key,int value) {
        ListNode node = cache.get(key);

        if (node == null) {
            ++size;
            if (size > capacity) {
                int removeKey = removeTail();
                --size;
                cache.remove(removeKey);
            }
            ListNode newNode = new ListNode(key, value);
            cache.put(key,newNode);
            addToHead(newNode);
        }else {
            node.value = value;
            move2Head(node);
        }
    }


    /**
     * 节点存在，移动到头部
     * @param currentNode
     */
    private void move2Head(ListNode currentNode) {

        removeNode(currentNode);
        addToHead(currentNode);

    }

    private void addToHead(ListNode currentNode) {
        ListNode headNext = head.next;
        headNext.pre = currentNode;
        currentNode.next = currentNode;
        head.next = currentNode;
        currentNode.pre = head;
    }

    private void removeNode(ListNode currentNode) {
        ListNode pre = currentNode.pre;
        ListNode next = currentNode.next;
        pre.next = next;
        next.pre = pre;
    }

    private int removeTail() {
        ListNode tailPre = tail.pre;
        tailPre.pre.next = tail;
        tail.pre = tailPre.pre;

        return tailPre.key;
    }



    class ListNode {
        ListNode pre;
        ListNode next;
        int value;

        int key;

        public ListNode(int key,int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {
        }
    }
}

