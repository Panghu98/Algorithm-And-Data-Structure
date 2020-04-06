package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class    Solution338A {


    /**
     * 获得二进制最高数位
     * num = 1,ret = 1;
     * num = 2,ret = 2;
     * num = 3,ret = 2;
     */
    private static int getNum(int num){
        int i = 1;
        int flag = 0;
        while (i <= num){
            i *= 2;
            flag++;
        }
        return flag;
    }

    private static int getCount(int num) {
        if (num == 0){
            return 0;
        }
        int ret = getNum(num);
        int flag = 0;
        for (int i = ret-1; i >= 0 ; i--) {
            int temp = 1 << i;
            if (num >= temp) {
                num = num - (temp);
                flag++;
            }
        }
        return flag;
    }

    public  int[] countBits(int num) {
        int[] arr = new int[num+1];
        for (int i = 0; i <= num; i++) {
            arr[i] = getCount(i);
        }
        return arr;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(countBits(5)));
    }

}
