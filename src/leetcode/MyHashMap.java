package leetcode;

import org.junit.Test;

import java.util.Optional;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 12:09 2021/3/14
 * @Modified By:
 */
//public class Leetcode706 {
//
//}

public class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    Node[] buckets;

    int count;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Node[16];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucketsIndex = getBucketsIndex(key);

        // 首节点不在
        if (buckets[bucketsIndex] == null) {
            buckets[bucketsIndex] = new Node(key,value,null);
            ++count;
        }else {
            Node head = buckets[bucketsIndex];

            if (head.key == key) {
                head.value = value;
                return;
            }

            while (head.next != null) {
                if (head.next.key == key) {
                    head.next.value = value;
                    return;
                }else {
                    head = head.next;
                }
            }

            head.next = new Node(key,value,null);
            ++count;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketsIndex = getBucketsIndex(key);
        Node head = buckets[bucketsIndex];
        while (head != null ) {
            if (head.key != key) {
                head = head.next;
            }else {
                return head.value;
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketsIndex = getBucketsIndex(key);
        Node head = buckets[bucketsIndex];

        if (head == null) {
            return;
        }

        if (head.key == key) {
            Node next = head.next;
            buckets[bucketsIndex] = next;
            --count;
            return;
        }

        while (head.next != null) {
            if (head.next.key != key) {
                head = head.next;
            }else {
                Node current = head.next;
                head.next = current.next;
                current = null;
                --count;
            }
        }

    }

    private int getBucketsIndex(int key) {
        // 模拟Hash
        return key % buckets.length;
    }

    @Test
    public void test() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1,1);
        hashMap.put(2,2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2,1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));

    }
}
