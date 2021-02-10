package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:31 2021/2/10
 * @Modified By:
 */
public class Leetcode567 {

    private boolean success = false;

    private String conditions;

    public boolean checkInclusion(String s1, String s2) {
        conditions = s2;
        String[] split = s1.split("");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
        fullArr(new LinkedList<>(),list);
        return success;
    }

    private void fullArr(LinkedList<String> str, List<String> remind) {
        if (str.size() == remind.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            str.forEach(stringBuilder::append);
            if (conditions.contains(stringBuilder.toString())) {
                success = true;
            }

            return;
        }

        for (int i = 0; i < remind.size(); i++) {

            String item = remind.get(i);

            // 这种check的方式修改一下
             if (str.contains(item)) {
                 continue;
             }

            str.add(item);
            fullArr(str,remind);
            str.removeLast();
        }

    }

    @Test
    public void test() {
        System.out.println(checkInclusion("hello","ooolleoooleh"));
    }


}
