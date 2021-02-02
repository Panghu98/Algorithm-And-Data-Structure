package leetcode;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:12 2021/2/2
 * @Modified By:
 */
public class Leetcode752 {

    public int openLock(String[] deadArr, String target) {

        Set<String> denied = new HashSet<>();
        // 验证时候无法进入
        for (int i = deadArr.length - 1; i >= 0; i--) {
            denied.add(deadArr[i]);
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String head = queue.poll();

                // 不允许访问的
                if (denied.contains(head)) {
                    continue;
                }

                if (head.equals(target)) {
                    return step;
                }

                for (int i = 0; i < 4; i++) {
                    String up = plusOne(head, i);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(head, i);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }

            step++;
        }

        return -1;

    }

    // 将 s[j] 向上拨动一次
    private  String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

}
