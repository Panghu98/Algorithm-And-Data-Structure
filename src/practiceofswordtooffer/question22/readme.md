## 题目
输入一个链表，输出该链表中倒数第k个结点。

**节点的结构**

 ``` 
 public class ListNode { 
    
    int val;
    ListNode next = null;
    
    ListNode(int val) {
        this.val = val;
    }
} 
```
## 思路
1. 正数第n(链表长度) - k + 1 
> 需要遍历两次
2. 快慢指针
> 一个指针在另外一个指针的k-1距离后,原理和第一个类似,
但是只需要遍历一遍