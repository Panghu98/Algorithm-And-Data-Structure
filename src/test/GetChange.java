package test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:57 2020/2/28
 * @Modified By:
 */
public class GetChange {

    public static int getChange(int amount,int[] coins) {
        if (amount == 0) {
            return 0;
        }

        //说明没有满足的条件
        if (amount < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = getChange(amount-coins[i],coins);
            if (subMin == -1) {
                continue;
            }

            result = Math.min(subMin+1,result);
        }

        //说明没有符合问题的解
        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int amount = 20;
        int[] coins = {1,2,5};
        int result = getChange(amount,coins);
        System.err.println(result);
    }

}
