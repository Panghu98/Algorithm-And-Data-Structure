package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 13:00 2021/1/14
 * @Modified By:
 */
public class Leetcode1018 {

    /**
     * 上一位的余数结果，借用到这一步
     * @param arr
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] arr) {


        List<Boolean> list = new ArrayList<>();

        // 上一位的余数
        int lastRemainder = 0;

        // 记录无效的尾数
        int invalidOffset = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                break;
            }
            invalidOffset++;
        }

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            current = getCount(i - invalidOffset,current);
            // 上次的余数
            current += lastRemainder;
            System.err.println(current);

            int currentRemainder = current % 5;
            // 记录是否整除
            list.add(currentRemainder == 0?Boolean.TRUE:Boolean.FALSE);
            lastRemainder = currentRemainder;
        }

        return list;
    }

    /**
     *
     * @param offset 向右移的位数
     * @param value
     * @return
     */
    private int getCount(int offset,int value) {

        if (value == 0) {
            return 0;
        }

        for (int i = 0; i < offset; i++) {
            value = value << 1;
        }

        return value;
    }

    @Test
    public void test() {
        List<Boolean> list = prefixesDivBy5(new int[]{1,1,0,0,0,1,0,0,1});
        list.forEach(System.out::println);
    }

}
