## 题目
输入一个链表，反转链表后，输出新链表的表头。

```
static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
```

## 思路
> 这一题有点类似于反向输出链表值

1. 直接使用递归实现(可能会出现栈溢出的问题)
2. 使用循环

