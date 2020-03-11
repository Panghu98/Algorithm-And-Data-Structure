package practiceofswordtooffer.question35;

//链接：https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba?answerType=1&f=discussion
//        来源：牛客网

/**
 *解题思路：
 *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
 *3、拆分链表，将链表拆分为原链表和复制后的链表
 * @author dengg
 */
public class Solution {

    public class RandomListNode {
        /**
         * 节点的值
         */
        int label;
        /**
         * 指向下一个节点
         */
        RandomListNode next = null;
        /**
         * 指向随机节点
         */
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1.复制接点，如复制节点A得到A'，将复制的节点插入到被复制节点的后面
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = cloneNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        currentNode = pHead;
        while (currentNode != null) {
            //复制节点指向对应的复制节点
            currentNode.next.random = currentNode.random == null?null:currentNode.random.next;
            //位移两位，跳过复制的节点
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        //需要保存复制节点的头结点信息
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            //当前节点的复制节点
            RandomListNode cloneNode = currentNode.next;
            //将当前节点指向复制节点的下一个节点（即原来的节点）
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null?null:cloneNode.next.next;
            //移动到下一个非复制节点
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }

}
