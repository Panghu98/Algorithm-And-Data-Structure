package leetcode_tencent;

import org.junit.Test;
import practiceofswordtooffer.question18.Solution;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author: panghu
 * @Description:
 *
 *
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  <strong>对于这个最近最少使用我觉得是有歧义的</strong>
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */
        /*
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
 *
 * @Date: Created in 22:24 2020/3/24
 * @Modified By:
 */
public class Solution146 {

    // 内置数据记录存储器
    private HashMap<Integer,Integer> dataMap = new HashMap<>();

    // 内置使用次数记录存储器，记住一个特点，新进来的一定是使用次数最少的那个
    // 需要排除之前使用最少的那一个
    private HashMap<Integer,Integer> countMap = new HashMap<>();

    private Integer getMinCountKey() {
        Integer minCount = Integer.MAX_VALUE;
        Integer minCountKey = 0;
        for (Integer key : countMap.keySet()) {
            Integer count = countMap.get(key);
            if (count < minCount) {
                minCount = count;
                minCountKey = key;
            }
        }
        return minCountKey;
    }

    private Integer maxCapacity;

    public Solution146() {
        this.maxCapacity = 2;
    }


    public int get(int key) {


        // 返回数据
        Integer value = dataMap.get(key);
        if (value != null) {
            //增加count值
            countMap.replace(key,countMap.get(key)+1);
        }
        return value == null?-1:value;
    }

    public void put(int key, int value) {
        if (dataMap.size() == maxCapacity) {
            // 进行元素删除操作。
            Integer minCountKey = getMinCountKey();
            dataMap.remove(minCountKey);
            countMap.remove(minCountKey);
        }
        dataMap.put(key,value);
        countMap.put(key,0);
    }


    @Test
    public void test()  {
        Solution146 cache = new Solution146();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
        System.out.println();
    }

}
