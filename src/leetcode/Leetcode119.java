package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 12:40 2021/2/12
 * @Modified By:
 */
public class Leetcode119 {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }

        for (int i = 1; i <= rowIndex; i++) {
            list.add(1);
        }

        // 实际上是第二行
        for (int i = 1; i <= rowIndex; i++) {
            // 从0开始无需加一
            // 最边上的始终是1
            // 第二的和当前行一样
            for (int j = i; j >= 0; j--) {

                if (j == 0 || j == i) {
                    list.set(j, 1);
                    continue;
                }

                Integer pre = list.get(j - 1);
                Integer value = list.get(j);
                list.set(j,pre + value);
            }

        }

        return list;
    }

    @Test
    public void test() {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }

}
