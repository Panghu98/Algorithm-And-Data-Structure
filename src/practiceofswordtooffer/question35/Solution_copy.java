package practiceofswordtooffer.question35;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:52 2020/3/10
 * @Modified By:
 */
public class Solution_copy {

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

    public RandomListNode clone(RandomListNode head) {
        //参数判断
        if (head == null) {
            return null;
        }


        RandomListNode currentNode = head;
        //clone node
        while (currentNode != null) {
            RandomListNode copyNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            copyNode.next = nextNode;
            currentNode.next = copyNode;
            currentNode = nextNode;
        }

        //clone the reference of random
        currentNode = head;
        while (currentNode != null) {
            //复制节点指向对应的复制节点
            currentNode.next.random = currentNode.random == null?null:currentNode.random.next;
            //位移两位，跳过复制的节点
            currentNode = currentNode.next.next;
        }

        currentNode = head;
        RandomListNode cloneNodeHead = head.next;
        while (currentNode != null) {
            //当前节点的复制节点
            RandomListNode cloneNode = currentNode.next;
            //将当前节点指向复制节点的下一个节点（即原来的节点）
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null?null:cloneNode.next.next;
            //移动到下一个非复制节点
            currentNode = currentNode.next;
        }
        return cloneNodeHead;

    }




}
