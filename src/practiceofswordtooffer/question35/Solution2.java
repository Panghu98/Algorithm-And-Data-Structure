package practiceofswordtooffer.question35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengg
 */
public class Solution2 {

    public class RandomListNode2 {
        /**
         * 节点的值
         */
        int label;
        /**
         * 指向下一个节点
         */
        RandomListNode2 next = null;
        /**
         * 指向随机节点
         */
        RandomListNode2 random = null;

        RandomListNode2(int label) {
            this.label = label;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public RandomListNode2 clone(RandomListNode2 pHead) {

        if (pHead == null) {
            return null;
        }

        RandomListNode2 newHead = null;
        RandomListNode2 p = pHead;
        RandomListNode2 q = null;
        //用于存储新的节点和复制节点之间的关联
        Map<RandomListNode2,RandomListNode2> map = new HashMap<>(8);
        while(p != null){
            //复制节点的头结点为空则复制原节点的值并创建一个新的节点
            if(newHead == null){
                newHead = new RandomListNode2(pHead.label);
                //将复制节点的头结点存储到q
                q = newHead;
                map.put(pHead, newHead);
            }else{
                //如果原节点对应的对应的
                if(p.next!= null && map.containsKey(p.next)) {
                    q.next = map.get(p.next);
                } else{
                    if(p.next!= null){
                        RandomListNode2 temp = new RandomListNode2(p.next.label);
                        map.put(p.next, temp);
                        q.next = temp;
                    }
                }
                if(p.random != null && map.containsKey(p.random)) {
                    q.random = map.get(p.random);
                } else{
                    if(p.random != null){
                        RandomListNode2 temp = new RandomListNode2(p.random.label);
                        map.put(p.random, temp);
                        q.random = temp;
                    }
                }
                p = p.next;
                q = q.next;
            }
        }
        return newHead;
    }

}
